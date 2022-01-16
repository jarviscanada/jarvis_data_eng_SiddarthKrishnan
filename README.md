# Siddarth Krishnan . Jarvis Consulting

I'm a Computer Science graduate passionate about software development and eager to learn about frameworks and dependencies used for large scale projects. I dabbled in JavaScript, shell programming, and data analysis with Python during my undergrad. Though my personal projects in school were sparse, I am gaining confidence and software acumen working at Jarvis. Java, Linux, and SQL are tools I'm using to further my knowledge at Jarvis, where I'm learning concepts like virtual memory, interfacing with HTTP for API requests, and JDBC abstraction to name just a few. I hope to continue writing code to build applications and explore database concepts. I enjoy working on software, exploring math behind algorithms, and practicing object-oriented styles of programming. I'm keen to learn about how data moves in and out of applications efficiently, and analytics for different types of data (e.g. time-series).

## Skills

**Proficient:** Java, Linux/Bash, RDBMS/SQL, Agile/Scrum, Microsoft Office

**Competent:** Python, C++, Smalltalk, Docker, Javascript

**Familiar:** PyTorch, React, Vue, MATLAB, Rust

## Jarvis Projects

Project source code: [https://github.com/jarviscanada/jarvis_data_eng_SiddarthKrishnan](https://github.com/jarviscanada/jarvis_data_eng_SiddarthKrishnan)


**Cluster Monitor** [[GitHub](https://github.com/jarviscanada/jarvis_data_eng_SiddarthKrishnan/tree/master/linux_sql)]: Developed a monitoring program using Bash scripts and PostgreSQL for a Linux cluster to track hardware usage statistics, such as CPU, RAM, and disk. Linux servers are connected locally, and the script periodically populates a table with each node's current usage information. It was apparent that virtual memory comprises process info, memory, CPU scheduling, and other statistics. Logging memory statistics was a good exercise in understanding file partitions, which manage storage space on the OS. SQL statements were embedded in our bash scripts to initialize tables inside a docker container running Postgres. We chose to run our database in docker because of its convenience for development. Lastly, we made sure to add the script that tracks host usage in our crontab because this is information that we need periodically.

**Core Java Apps** [[GitHub](https://github.com/jarviscanada/jarvis_data_eng_SiddarthKrishnan/tree/master/core_java)]:
      
  - Twitter App: Currently working on CRUD app for Twitter to learn APIs. Using HTTP and json within java.
  - JDBC App: Implemented  a Java JDBC application that persists data in a PostgreSQL database, provisioned using Docker. The client-side JDBC was used to access RDBMS, to abstract CRUD operations. I used the data access object (DAO) pattern in java classes to execute SQL statements. The DAO classes were implemented using JDBC to perform operations on an existing database of customers and orders. DAO classes abstract how orders are persisted in the database but can return us an order using the JDBC ResultSet API. Used PreparedStatements from JDBC for precompiled SQL, to which we can pass input parameters.
  - Grep App: Reimplemented the bash grep command in a java application. This app made use of java regex classes and file handling to test its usage for text files. The testing was done by appending lines with matching regex patterns to a single file. Furthermore, the class files and dependencies were packaged in an uber jar using maven and its shade plugin. This ensured that the JVM would find class files in both our classpath and pom file dependencies. The project was finally dockerized using a docker file to build the image. I also looked into using streams and buffered readers to optimize heap memory when operating on lists of strings. Serialized data is an improvement over java collections when we're only traversing the collection once. Streams are constructed lazily, which can be useful in scenarios where our operation stops prematurely (e.g. cancelling data being loaded).


## Highlighted Projects
**Machine learning object recognition assignment**: Our goal was to create a machine learning model (neural network architecture) to identify objects by a class label. We wanted to understand why deep learning was preferable for computer vision tasks. We used Python and tensorflow along with a transfer learning approach, adapting a prefined CNN for our dataset. We had a hard time achieving classification lower than standard benchmarks for the R-CNN models. We could have focused more on preprocessing data and adjusting the network through drop layers. We also should have read more literature on networks for image classification as we were unable to correct overfitting and accuracy issues in the given time.


## Professional Experiences

**Junior Software Developer, Jarvis (2021.11-present)**: Gaining experience with many development tools and programming paradigms. Working in an Agile/Scrum team and developing applications with Linux, SQL, and Java. As a scrum team lead, I work with team members while also leading meetings and keeping track of individuals' progress and impediments to success. This role involves meeting deadlines for application development and demonstrating technical acumen in code reviews upon finishing projects. I am also involved in sprint retrospectives that allow our team opportunities to evaluate our performance and discuss technical or communication improvements to make for the following sprints. I also try actively participate in Slack channels for different projects to seek help or provide tips from my own programming knowledge.

**Cast Member, Cineplex (2021.9-2022.1)**: I worked in all areas of the theatre, whether that involved serving food and preparing orders, or doing theatre checks. Vaccine certificate checks for all theatre entrants was one of my primary duties. I always tried to promote a welcoming environment for moviegoers during the pandemic. Every shift of mine required closing duties to ensure an easy opening for the next day. Laid off after New Year's day due to COVID restrictions.

**Customer Experience Associate, Walmart (2018.5-2020.9)**: I managed the electronics deparment in a Walamrt Superstore. This involved cashier duties and advising customers about media products and electronics.


## Education
**Ryerson University (2018-2021)**, Bachelor of Science, Computer Science
- GPA: 3.3/4


## Miscellaneous
- Receational sports - I often organize football and basketball outdoors among university peers and other friends.
- Reading
- Math: personal study for my interest in deep learning (statistics and multivariable calculus)