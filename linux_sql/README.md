# Introduction
This project explores how we can monitor servers/nodes running in a cluster, allows them to communicate through switches.
These nodes running CentOS 7 communicate through the switching of ethernet packets. We can use the bash shell
to collect hardware and resource usage information among nodes on the same network. This information will be made available
to use for the Jarvis LCA team. The technologies used include git, docker, postgresql, and bash.

# Quickstart
Run the psql_docker.sh script with `./psql_docker <cmd> username password` from the scripts directory. The cmd options 
can either create, stop, or start a container. The script will create a docker container and volume if the jrvs-psql container 
doesn't already exist. Next, run the ddl.sql file from postgres with the command `psql -h localhost -U postgres -d host_agent -f sql/ddl.sql`
Run the file host_info.sh with `./scripts/host_info.sh "localhost" 5432 "host_agent" "postgres" "mypassword"`
Run the file host_usage.sh with `./scripts/host_usage.sh "localhost" 5432 "host_agent" "postgres" "mypassword"`
In order for host_usage to run every minute, edit cronjobs: 
```
bash > crontab -e
#in crontab add this:
* * * * * bash /home/centos/dev/jrvs/bootcamp/linux_sql/host_agent/scripts/host_usage.sh localhost 5432 host_agent
 postgres password > /tmp/host_usage.log
```
# Implementation 
The implementation of this project is intended to get help get acquainted with a linux environment and relation databases
through SQL. The lscpu command line tool gets us CPU information about the system. The vmstat command
is the performance monitoring command in linux, which aligns with our requirements. It gives us disk information and values
related to percent of cpu time. So these two utilites report all the information we need for our
usage and info tables. We can write a script for hosts to register their information (hardware specific) and another
that can be called to view a host's current usage stats. By placing the usage script in your crontab jobs as described
above, the script will add an entry about your usage to the host_usage table every minute.

# Architecture
![alt text](https://github.com/jarviscanada/jarvis_data_eng_SiddarthKrishnan/blob/develop/linux_sql/assets/mock_draw.jpg "Logo Title Text 1")

## Scripts
psql_docker.sh - Can start, stop, or create jrvs-psql container.The script will only create the container if it doesn't 
already exist. A username and password will be required for all 3 cases. 

host_info.sh - This script can be called as shown above to insert host hardware information into the
existing host_info database. The script requires host, port, database, username and password to call.

host_usage.sh - This script can be called as shown above to insert host usage information into the
existing host_usage database. The script requires host, port, database, username and password to call.

The crontab lists commands to run at regular intervals. Our goal was to poll host usage statistics
available about every minute. We add the cronjob to our crontab by adding the follwing line in our crontab:
`* * * * * bash /home/centos/dev/jrvs/bootcamp/linux_sql/host_agent/scripts/host_usage.sh localhost 5432 host_agent
postgres password > /tmp/host_usage.log`

SQL queries - The first query for our postgres database makes the data slightly more user-friendly for business needs. 
It groups hosts by cpu numbers and sorts within the groups by memory size. This query makes it easy to see how memory changes
relative to cpu number as we list all our hosts. Our second query finds the average memory used over each 5 minute interval 
for each host. The last query detects error if there are fewer than 3 entries pertaining to a host for any 5 minutes window 
in the host_usage table. 

## Database Modelling
host_info
    id (SERIAL), hostname (VARCHAR), cpu_number (INTEGER), cpu_architecture (VARCHAR), cpu_model (VARCHAR), 
    cpu_mhz (FLOAT), l2_cache (INTEGER), total_mem (INTEGER), timestamp (TIMESTAMP)

host_usage
    host_id (SERIAL), memory_free (INTEGER), cpu_idle (INTEGER), cpu_kernel (INTEGER), disk_io (INTEGER),
    disk_available (INTEGER), timestamp (timestamp)
# Test
As this is meant to be a minimum viable product, testing was conducted on a single machine. The assumption is
that with firewalls and networks setup properly, this product will work in a linux cluster. The SQL queries were 
tested by inserting sample data points for testing. The bash scripts were tested with manual docker
commands and manipulating the database records through the psql CLI. 

# Deployment
This project was deployed with docker and Github. The shell scripts and queries are available on
Github. To deploy, a docker container based on the postgres image is required. This may be pulled from 
the docker registry with `docker pull postgres`. After making sure the postgres image is available,
the psql_docker script can be run to setup the image. The ddl.sql file can be called from psql to initialize 
the two databases for this project.

# Improvements 
To further the knowledge gained through this project, it might be wise to investigate how host hardware
changes would affect the database. Figuring out how to update our host information through bash scripting to 
automate table changes would be a good next step. It could be fun to figure out what tools may 
be used to restrict nodes that are using too resource heavy for a period of time. Furthermore, the usage information
could have another component that makes application specific details available to the linux cluster admin team.

