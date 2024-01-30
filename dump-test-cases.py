import os
import sys
import json
import pathlib


def write_as_json(data, output_file_path: str):
    content = json.dumps(data)
    with open(output_file_path, "w") as out_file:
        out_file.writelines(content)

def read_json(file_path: str):
    json_data = None
    if os.path.isfile(file_path):
        with open(file_path, "r") as in_file:
            content = in_file.readlines()
            if len(content) > 1:
                content_str = " ".join([l.strip().replace("\n", "") for l in content])
            else:
                content_str = content[0]
            json_data = json.loads(content_str)
    return json_data

meta_data = read_json("meta-data.json")
for bug in meta_data:
    test_id_list = bug["failing_test_identifiers"] + bug["passing_test_identifiers"]
    subject = bug["subject"]
    bug_id = bug["bug_id"]
    dir_name = f"{subject}/{bug_id}"
    file_name = f"{dir_name}/test-cases"
    open(file_name, "w").writelines([x + "," for x in test_id_list])
