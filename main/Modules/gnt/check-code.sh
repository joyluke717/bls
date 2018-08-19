#!/bin/bash
#set -x

if [ -z "$PMDRUN" ]; then
    echo -e "Need to set envrionment variable PMDRUN, e.g. export PMDRUN=~/tools/pmd-bin-6.2.0/bin/run.sh"
    echo -e "Please refer to wiki https://github.com/glicxu/i2deploy/wiki/PMD for details."
    exit 1
fi

PMD_RULESET=java-basic,java-empty,java-imports,java-unnecessary,java-unusedcode
out_file=pmd.txt
echo -e ${PMDRUN}
${PMDRUN} pmd -d src -R ${PMD_RULESET} -f text -version 1.8 -language java > ${out_file}
echo -e "PMD generated a report file: ${out_file}"

if [ -z "$SPOTBUGSRUN" ]; then
    echo "Need to set envrionment variable SPOTBUGSRUN, e.g. export SPOTBUGSRUN=~/tools/spotbugs-3.1.1/bin/spotbugs"
    echo "Please refer to wiki https://github.com/glicxu/i2deploy/wiki/Spotbugs for details."
    exit 1
fi

out_file=sb_medium.txt
maven_repo=${HOME}/.m2/repository
echo ${SPOTBUGSRUN}
${SPOTBUGSRUN} -maxHeap 512 -effort:min -medium -auxclasspath ./bin/target/lib:${maven_repo}/com/ibatis/ibatis2-common:${maven_repo}/org/jsoup/jsoup:${maven_repo}/io/dropwizard/dropwizard-client:${maven_repo}/org/apache/httpcomponents/httpclient -output ${out_file} target/classes/ target/test-classes/
echo -e "Spotbugs generated a report file: ${out_file}"

