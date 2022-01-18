# Siddarth Krishnan . Jarvis Consulting

I'm a Computer Science graduate passionate about software development and eager to learn frameworks and dependencies used for large-scale projects. I dabbled in JavaScript, shell programming, and data analysis with Python during my undergrad. Java, Linux, and SQL are tools I'm using at Jarvis, where I'm learning concepts like virtual memory, interfacing with HTTP for API requests, and JDBC abstraction. I hope to continue writing code to build applications and explore database concepts. I enjoy working on software, exploring math behind algorithms, and practicing object-oriented programming styles. I'm keen to learn how data moves in and out of applications efficiently for cloud services, and analytics for different data types (e.g. time-series). Serverless computing and decentralized financial applications are technological paradigms that I find fascinating.

## Skills

**Proficient:** Java, Linux/Bash, RDBMS/SQL, Agile/Scrum, Microsoft Office

**Competent:** Python, C++, Smalltalk, Docker, Javascript

**Familiar:** PyTorch, React, Vue, MATLAB, Rust

## Jarvis Projects

Project source code: [https://github.com/jarviscanada/jarvis_data_eng_SiddarthKrishnan](https://github.com/jarviscanada/jarvis_data_eng_SiddarthKrishnan)


**Cluster Monitor** [[GitHub](https://github.com/jarviscanada/jarvis_data_eng_SiddarthKrishnan/tree/master/linux_sql)]: Developed a monitoring program using Bash scripts and PostgreSQL for a Linux cluster to track hardware usage statistics, such as CPU, RAM, and disk. The Linux servers are connected locally, and our script periodically populates a table with each node's current usage information. I learned how virtual memory comprises process info, memory, CPU scheduling, and other statistics. Logging these memory statistics was a good exercise in understanding file partitions, which manage storage space on the OS. SQL statements were inserted into the bash scripts to initialize tables inside a docker container running PostgreSQL. We chose to run our database in docker because of its convenience for development. Lastly, we made sure to add the script that tracks host usage in our crontab because this is information that we need periodically.

**Core Java Apps** [[GitHub](https://github.com/jarviscanada/jarvis_data_eng_SiddarthKrishnan/tree/master/core_java)]:
      
  - Twitter App: Currently working on CRUD app for Twitter to learn APIs. Using an HTTP client and parsing json within java classes. I am testing CRUD features with JUnit and Mockito
  - JDBC App: Implemented  a Java JDBC application that persists data in a PostgreSQL database, provisioned using Docker. The client-side JDBC was used to access RDBMS, to abstract CRUD operations. I used the data access object (DAO) pattern in java classes to execute SQL statements. The DAO classes were implemented using JDBC to perform operations on a customers and orders database. I learned that data access object classes can be used to model operations and return the underlying object they represent. For example, an OrderDAO may comprise all operations we want for a table of orders and also return an Order object for business logic using the JDBC ResultSet API. PreparedStatements from JDBC were used to write precompiled SQL, to which we passed input parameters.
  - Grep App: Reimplemented the grep Shell command in java. I used regex classes and file handling to test the java grep on text files. I tested the java methods by appending the lines with matching regex patterns to a single file. Furthermore, I packaged the class files and dependencies in an uber jar using maven and its shade plugin. The uber jar was required so that the JVM would find class files in both our classpath and pom file dependencies. For deployment, the project was dockerized using a docker file to build the corresponding image. I also looked at using streams and buffered readers to optimize heap memory when operating on lists of strings. Serialized data is an improvement over java collections when we traverse a collection only once. Streams use serialization and are constructed lazily, which can be useful in scenarios where our operation stops prematurely (e.g. cancelling data being loaded). I hope to learn more about memory optimization techniques for application development.


## Highlighted Projects
**Machine learning object recognition assignment**: Our goal was to create a machine learning model (neural network architecture) to identify objects by a class label. We wanted to understand why deep learning was preferable for computer vision tasks. We used Python and tensorflow along with a transfer learning approach, adapting a prefined CNN for our dataset. We had a hard time achieving classification lower than standard benchmarks for the R-CNN models. We could have focused more on preprocessing data and adjusting the network through drop layers. We also should have read more literature on networks for image classification as we were unable to correct overfitting and accuracy issues in the given time.


## Professional Experiences

**Junior Software Developer, Jarvis (2021.11-present)**: Gaining experience with many development tools and programming patterns, working in an Agile/Scrum team and developing applications with Linux, SQL, and Java. As a scrum team lead, I work with team members while also leading meetings and keeping track of individuals' progress and impediments to success. This role involves meeting deadlines for application development and demonstrating technical acumen in code reviews upon finishing projects. I am also involved with sprint retrospectives that give our team opportunities to evaluate our performance and discuss technological or communication improvements to make for the following sprints. I also participate in Slack channels discussions for different projects to seek help or provide tips from my own programming knowledge.

**Cast Member, Cineplex (2021.9-2022.1)**: I worked in all areas of the theatre, whether that involved serving food and preparing orders, or doing theatre checks. Vaccine certificate checks for all theatre entrants was one of my primary duties. I always tried to promote a welcoming environment for moviegoers during the pandemic. Every shift of mine required closing duties to ensure an easy opening for the next day.

**Customer Experience Associate, Walmart (2018.5-2020.9)**: I managed the electronics deparment in a Walamrt Superstore. This involved cashier duties and advising customers about media products and electronics.


## Education
**Ryerson University (2018-2021)**, Bachelor of Science, Computer Science
- GPA: 3.3/4


## Miscellaneous
- Receational sports - I often organize football and basketball outdoors.
- Reading
- Studying deep learning and prerequisite math that I excelled in at university, including statistics, multivariable calculus, and linear algebra.