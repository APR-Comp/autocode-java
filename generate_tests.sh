#/bin/bash
if [ -z "$1" ];
then
    echo "Provide test selection - public or private"
    exit 1
fi

if [ "$1" != "public" ] && [ "$1" != "private" ];
then
    echo "Only possible selections are public or private"
    exit 1
fi

ROOT=$PWD

cd testcases
START=$PWD

for problem in ./*/;
do
 echo $problem
 #if [ $problem != "./beautiful-towers-i/" ] ;
 #then continue
 #fi
 
 echo $problem
 cd $problem/jazzer
 rm -rf outputs
 mkdir outputs
 mvn clean
 JAZZER_FUZZ=1 TEST_TYPE=$1 mvn test
 private_tests=$(find ./outputs | shuf -n 100)
 public_tests=$(find ./outputs | shuf -n 10)
 for submission in $ROOT/$problem/*/;
 do
    echo $submission
    
    #echo $private_tests > $submission/private_tests
    #echo $public_tests > $submission/public_tests

    if [  "$1" == "public" ];
    then
        rm $submission/src/test/java/com/aprcomp/*new_*.java
        for test in $public_tests ;
        do
            cp $test $submission/src/test/java/com/aprcomp/$(basename $test)
        done
    else
        rm $submission/private-tests/src/test/java/com/aprcomp/*new_*.java
        for test in $private_tests ;
        do
            cp $test $submission/private-tests/src/test/java/com/aprcomp/$(basename $test)
        done
    fi
 done
 cd $START
done