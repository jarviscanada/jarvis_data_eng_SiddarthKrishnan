psql_host=$1
psql_port=$2
db_name=$3
psql_user=$4
psql_password=$5

if [ $# -ne  5 ]
then
  echo "missing args"
  exit 1
fi
hostname=$(hostname -f)

#Retrieve hardware specification variables
#xargs is a trick to trim leading and trailing white spaces
cpu_number=$(lscpu | egrep "^CPU\(s\):" | awk '{print $2}' | xargs)
cpu_architecture=$(lscpu  | egrep "^Architecture:" | awk '{print $2}' | xargs)
cpu_model=$(lscpu | egrep "^Model name:" | awk '{$1=$2=""; print $0}' | xargs)
cpu_mhz=$(lscpu | egrep "^CPU MH" | awk '{print $3}' | xargs)
l2_cacheM=$(lscpu | egrep "^L2" | awk '{print $3}' | xargs)
l2_cache=${l2_cacheM%?}
total_mem=$(grep MemTotal /proc/meminfo | awk '{print $2}')

timestamp=$(vmstat -t | awk '{print $18 " " $19}' | tail -n1)

insert_stmt="INSERT INTO host_info(timestamp, cpu_architecture, cpu_number, cpu_model, cpu_mhz, l2_cache, total_mem, hostname)
VALUES('$timestamp', '$cpu_architecture', '$cpu_number', '$cpu_model', '$cpu_mhz', '$l2_cache', '$total_mem', '$hostname');"

#set up env var for pql cmd
export PGPASSWORD=$psql_password

psql -h $psql_host -p $psql_port -d $db_name -U $psql_user -c "$insert_stmt"
exit $?