import time
import sys
import re
from python_graphql_client import GraphqlClient
from pprint import pprint
import requests
import openai
import os
from os.path import join
import openai
import time
MAX_TOKENS = 1024
SOLUTIONS = 5

MAVEN_TEMPLATE="""
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
         <modelVersion>4.0.0</modelVersion>

         <groupId>com.aprcomp</groupId>
         <artifactId>aprcomp_ai_java</artifactId>
         <version>1.0-SNAPSHOT</version>

         <properties>
         <maven.compiler.source>8</maven.compiler.source>
         <maven.compiler.target>8</maven.compiler.target>
         </properties>
         
         <dependencies>
            <dependency>
                <groupId>junit</groupId>
                <artifactId>junit</artifactId>
                <version>4.12</version>
                <scope>test</scope>
            </dependency>
         </dependencies>
</project>  """

def completion_openAI(
        prompt, max_tokens=1024, temperature=0, num=1,model="gpt-4"
        ):
    openai.api_key = ("")
    response = openai.ChatCompletion.create(
            model=model,
            messages = [
                {"role": "system", "content": "You are an expert algorithmic problem solver, which autocompletes function definitions and outputs the contents of the function in triple backticks (```) without responding with any other text." },
                {"role": "user", "content": prompt},
                ],
            temperature=temperature,
            max_tokens=max_tokens,
            top_p=1.0,
            n=num,
            )
    return response


# Instantiate the client with an endpoint.
client = GraphqlClient(endpoint="https://leetcode.com/graphql/")

contest_query = """
query pastContests($pageNo: Int, $numPerPage: Int) {
pastContests(pageNo: $pageNo, numPerPage: $numPerPage) {
 pageNum
 currentPage
 totalNum
 numPerPage
 data {
  titleSlug
  startTime
  originStartTime
  }
 }
}
"""
contest_root = "https://leetcode.com/contest/api/info/{}"
problem_root = "https://leetcode.com/contest/{}/problems/{}/"

variables = {
        "pageNo": 1,
        "numPerPage": 120,
        }

data = client.execute(query=contest_query, variables=variables)

problem_query = """ query questionContent($titleSlug: String!) {
question(titleSlug: $titleSlug) {
content
difficulty
questionFrontendId
codeSnippets {
            lang
            langSlug
            code
        }
topicTags {
            name
        }
}
}
"""

full_query = """
query ($title_slug: String) {
    question(title_slug: $title_slug) {
        questionId
        questionFrontendId
        boundTopicId
        title
        titleSlug
        content
        translatedTitle
        translatedContent
        isPaidOnly
        difficulty
        likes
        dislikes
        isLiked
        similarQuestions
        exampleTestcases
        contributors {
            username
            profileUrl
            avatarUrl
        }
        topicTags {
            name
            slug
            translatedName
        }
        companyTagStats
        stats
        hints
        solution {
            id
            canSeeDetail
            paidOnly
            hasVideoSolution
            paidOnlyVideo
        }
        status
        sampleTestCase
        metaData
        judgerAvailable
        judgeType
        mysqlSchemas
        enableRunCode
        enableTestMode
        enableDebugger
        envInfo
        libraryUrl
        adminUrl
        challengeQuestion {
            id
            date
            incompleteChallengeCount
            streakCount
            type
        }
        note
    }
}
"""


from bs4 import BeautifulSoup

def java_process(problem_slug,problem_info, problem_description, snippets,difficulty=0):
    folder = "java"
    instance = join(folder,str(difficulty),"{}_{}".format(problem_slug,int(time.time())))
    os.makedirs(instance)
    java_test_template = """
    package com.aprcomp;
    import java.util.*;
    import org.junit.Test;
    import static com.aprcomp.Solution.*;
    import static org.junit.Assert.*;
    public class Test_{i} {{
        @Test(timeout=5000)
        public void test_{i}(){{
            assertEquals({out}, new Solution().{func}({inp}));
            }}
    }}
    """

    java_snippet = {}
    for snippet in snippets:
        if snippet["lang"] == "Java":
            java_snippet = snippet
            break
    print(java_snippet)

    if not re.match("^class Solution .*", java_snippet["code"], re.S):
        print("\n\n\nSKIP")
        return


    pattern_def = re.search("public [a-zA-Z\\[\\]<>]+ (.*)\(", java_snippet["code"])
    if not pattern_def:
        print("oof", java_snippet)
        return
    function_name = pattern_def.group(1)
    tests = []
    examples = problem_description.split("Example")[1:]
    for id, example in enumerate(examples):
        inp = re.search("Input: (.*)\n", example).group(1)
        inp_cleaned = ",".join(list(map(lambda i: i.split("=")[-1], inp.split(", "))))
        out = re.search("Output: (.*)\n", example).group(1)
        #print(inp,out)
        test = java_test_template.format(i=id, func=function_name,inp=inp_cleaned, out=out)
        tests.append(test)
        #print(test)


    prompt = "/**java \n {} **/\n{}".format(
            problem_description, java_snippet["code"][:-2]
            )
    description = "/**java \n {} **/\n".format(problem_description)
    while True:
        try:
            completions = completion_openAI(
                    prompt,
                    num=SOLUTIONS,
                    max_tokens=MAX_TOKENS,
                    temperature=0.8,
                    model="gpt-4",
                    )["choices"]+  completion_openAI(
                    prompt,
                    num=SOLUTIONS,
                    max_tokens=MAX_TOKENS,
                    temperature=0.8,
                    model="gpt-3.5-turbo"
                    )["choices"] 
            #print(completions)
            break
        except openai.error.RateLimitError as e:
            print("Sleep")
            time.sleep(60)
        except Exception as e:
            print("Got exception")
            print(e)
            sys.exit(1)

    for id,completion in enumerate(completions):
        completion_folder ="{}_{}".format(problem_slug,id)
        src_dir  = join(instance,completion_folder,"src","main","java","com","aprcomp")
        test_dir = join(instance,completion_folder,"src","test","java","com","aprcomp")
        os.makedirs(src_dir)
        os.makedirs(test_dir)
        try:
            code = completion.message.content.split('```')[1].rstrip()
            if code.startswith('java\n'):
                code = code[len('java\n'):]
            if not code.startswith('class'):
                code = java_snippet["code"][:-2] + code
            suffix = "\n};" if (code[-2:] != '};' and code[-1:] != '}')  else ''
            program_text = 'package com.aprcomp;\nimport java.util.*;\n' + description + code + suffix
            with open(join(src_dir,"Solution.java"), "w") as f:
                f.write(program_text)
                f.flush()
            with open(join(instance,completion_folder,"description.txt"), "w") as f:
                f.write(problem_description)
                f.flush()

            with open(join(instance,completion_folder,"pom.xml"),"w") as f:
                f.write(MAVEN_TEMPLATE)
                f.flush()

            for id,test in enumerate(tests):
                with open(join(test_dir,"Test_{}.java".format(id)),"w") as f:
                    f.write(test)
                    f.flush()
        except Exception as e:
            print(e)
        # print("")

id = 0
skipper = len(sys.argv) > 1
for contest in data["data"]["pastContests"]["data"]:
    contest_data = requests.get(contest_root.format(contest["titleSlug"])).json()[
            "questions"
            ]
    for question in contest_data:
        id = id + 1
        if id > 2:
            print("DONEEE")
            sys.exit(0)
        problem_slug = question["title_slug"]
        print(problem_slug)
        if skipper and  problem_slug == sys.argv[1]:
            skipper = False
        if skipper:
            print("SKIP")
            continue
        problem_url = problem_root.format(contest["titleSlug"], question["title_slug"])
        problem_info = client.execute(
                query=problem_query, variables={"titleSlug": question["title_slug"]}
                )
        #print(problem_info["data"]["question"]["exampleTestcases"])
        problem_description = BeautifulSoup(
                re.sub('<sup>(.*?)</sup>',' ** \\1',problem_info["data"]["question"]["content"]), features="lxml"
                ).get_text()
        difficulty = problem_info["data"]["question"]["difficulty"]
        tags = problem_info["data"]["question"]["topicTags"]
        #pprint(tags)
        snippets = problem_info["data"]["question"]["codeSnippets"]
        #print(problem_description)
        print("Ready to process")
        java_process(problem_slug,problem_info, problem_description, snippets,difficulty)
        print("Java done")
        #input()

# requests.get(contest_root+"")
