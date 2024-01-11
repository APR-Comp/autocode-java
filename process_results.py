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


dir_path = os.getcwd()
regex = "valkyrie"
valkyrie_dirs = list(pathlib.Path(dir_path).rglob(regex))
aggregated_results = []
for dir_name in valkyrie_dirs:
    problem_id = str(dir_name).split("/")[-4]
    solution_id = str(dir_name).split("/")[-3]
    bug_results = read_json(f"{dir_name}/output/result.json")
    bug_summary = dict()
    bug_summary["Problem"] = problem_id
    bug_summary["Solution"] = solution_id
    bug_summary["llmr"] = list()
    bug_summary["et"] = list()
    bug_summary["grt5"] = list()
    bug_summary["dev"] = list()

    for result in bug_results:
        patch_id, classification = result
        tool_name, patch_file = patch_id.split(":")
        bug_summary[tool_name].append(classification)
    aggregated_results.append(bug_summary)

write_as_json(aggregated_results, "aggregated.json")
