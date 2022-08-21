timestamp=$(date +%s)

#!/bin/bash

#########################################
# create environment variables...
YELLOW='\033[1;33m'
GREEN='\033[1;32m'
NO_COLOR='\033[0m'
DESCRIPTION='null'
NAMEFILE='null'
TIMESTAMP=$(date +%s)
DATE=$(date +%Y-%m-%d_%H.%M.%S)
#
#########################################
if [ $# -ge 1 ]; then
    DESCRIPTION=$1
else

        clear

        echo "create_migration"
        echo "-------------------------------------------------------------"
        echo "Enter the migration description or 0 EXIT:"
        read -p "" desc
        echo

        case $desc in
            [0]* ) exit 2;;
               * ) DESCRIPTION=$desc;;
        esac

fi

NAMEFILE="V${TIMESTAMP}__${DESCRIPTION}.sql"

echo "  Generating migration file..."
echo "  ${NAMEFILE}"
echo

touch "./migration/${NAMEFILE}"

echo "${GREEN}"
echo "*****************************************************************************************"
echo "  Migration file for ${NAMEFILE} generated"
echo "  ${DATE} - Finished!"
echo "*****************************************************************************************"
echo "${NO_COLOR}"
echo
