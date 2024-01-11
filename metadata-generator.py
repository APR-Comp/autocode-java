import os
import os.path
import shutil
template = """
    {{
        "id": {id},
        "source_directory": "src/main/java/",
        "class_directory": "target/classes/",
        "test_directory": "src/test/java",
        "test_class_directory": "target/test-classes/",
        "line_numbers": [],
        "dependencies": [],
        "language": "java",
        "java_version": 8,
        "build_system": "maven",
        "config_script": "config_subject",
        "build_script": "build_subject",
        "clean_script": "clean_subject",
        "test_script": "test_subject",
        "test_timeout": 5,
        "bug_type": "Test Failure",
        "subject": "{subject}",
        "bug_id": "{bug_id}",
        "source_file": "com.aprcomp.Solution",
        "failing_test": [{failing_tests}],
        "passing_test": [{passing_tests}],
        "count_neg": {failing_test_count},
        "count_pos": {passing_test_count}
    }},
"""

root = os.getcwd()

file = open("meta-data.candidate.json", "w")
file.write("[")
id = 0
skipper = ""
for subject in sorted(os.listdir('./')):
    if os.path.isfile(subject) or subject in ['testcases'] or subject.startswith('.'):
        continue
    
    # if not subject.startswith(skipper):
    #      continue
    # else:
    #      skipper = "NONE"
    
    for bug_id in sorted(os.listdir(subject)):
        if os.path.isfile(os.path.join(subject,bug_id)) or bug_id == ".aux" or bug_id == "base":
            continue
        id = id + 1

        shutil.copy(os.path.join(root, 'test_subject_local'),
                    os.path.join(subject, bug_id, 'test_subject'))
        os.chdir(os.path.join(subject, bug_id))

        passing_tests = []
        failing_tests = []
        print("I AM IN {}".format(os.getcwd()))
        for test in sorted(os.listdir(os.path.join('src', 'test', 'java', 'com', 'aprcomp'))):
            test_file = test[:-len('.java')]
            
            
            qualified_test_name = "com.aprcomp.{}".format(
                test_file)
            res = os.system("./test_subject '{}'".format(qualified_test_name))
            # print(res)
            if res == 0:
                passing_tests.append(qualified_test_name)
            else:
                failing_tests.append(qualified_test_name)

        # input()
        os.chdir(root)
        shutil.copy(os.path.join(root, 'test_subject'),
                    os.path.join(subject, bug_id, 'test_subject'))

        file.write(template.format(subject=subject,
                                   id=id,
                                   bug_id=bug_id,
                                   passing_tests=','.join(map(lambda x : f'"{x}"',passing_tests)),
                                   failing_tests=','.join(map(lambda x : f'"{x}"',failing_tests)),
                                   failing_test_count=len(failing_tests),
                                   passing_test_count=len(passing_tests)
                                   ))

file.write("]")
file.close()
