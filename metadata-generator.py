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
        "java_version": 11,
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
        "failing_test_identifiers": [{failing_test_identifiers}],
        "passing_test_identifiers": [{passing_test_identifiers}],
        "count_neg": {failing_test_identifiers_count},
        "count_pos": {passing_test_identifiers_count},
        "pvt_test_script": "run_private_tests",
        "pub_test_script": "run_public_tests",
        "root_abspath": "/experiment/{subject}/{bug_id}/src",
        "entrypoint": {
            "file": "src/main/java/com/aprcomp/Solution.java"
        },
    }},
"""

root = os.getcwd()

file = open("meta-data.candidate.json", "w")
file.write("[")
id = 0
skipper = ""
for subject in sorted(os.listdir('./')):
    if os.path.isfile(subject) or subject in ['testcases', 'crawler', 'configs', 'target'] or subject.startswith('.'):
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

        passing_test_identifiers = []
        failing_test_identifiers = []
        print("I AM IN {}".format(os.getcwd()))
        for test in sorted(os.listdir(os.path.join('src', 'test', 'java', 'com', 'aprcomp'))):
            test_file = test[:-len('.java')]
            
            
            qualified_test_name = "com.aprcomp.{}".format(
                test_file)
            res = os.system("./test_subject '{}'".format(qualified_test_name))
            # print(res)
            if res == 0:
                passing_test_identifiers.append(qualified_test_name)
            else:
                failing_test_identifiers.append(qualified_test_name)

        # input()
        os.chdir(root)
        shutil.copy(os.path.join(root, 'test_subject'),
                    os.path.join(subject, bug_id, 'test_subject'))

        file.write(template.format(subject=subject,
                                   id=id,
                                   bug_id=bug_id,
                                   passing_test_identifiers=','.join(map(lambda x : f'"{x}"',passing_test_identifiers)),
                                   failing_test_identifiers=','.join(map(lambda x : f'"{x}"',failing_test_identifiers)),
                                   failing_test_identifiers_count=len(failing_test_identifiers),
                                   passing_test_identifiers_count=len(passing_test_identifiers)
                                   ))

file.write("]")
file.close()
