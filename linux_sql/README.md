# Introdution
This project explores how we can monitor servers/nodes running in a cluster, allows them to communicate through switches.
These nodes running CentOS 7 communicate through the switching of ethernet packets. We can use the bash shell
to collect hardware and resource usage information among nodes on the same network. This information will be made available
to use for the Jarvis LCA team. The technologies used include git, docker, postgresql, and bash.

# Quickstart
Run the psql_docker script with `./psql_docker <cmd> username password` from the scripts directory. The cmd options 
can either be create, stop, or start. The script will create a docker container and volume if the jrvs-psql container 
doesn't already exist.
Next, run the ddl.sql file from postgres with the command ``
