# Siddarth Krishnan . Jarvis Consulting

I'm a recent computer science graduate passionate about software development, machine learning, and advances in the crypto space like decentralized finance. My excitement comes from seeing how we can identify patterns in big data sets using deep learning and different neural network architectures. I also pay attention to decentralized protocols and how developers use game theory for financial apps on Web3. I enjoy working on software, exploring math behind algorithms, and practicing object oriented styles of programming. I would also enjoy learning about how data moves in and out of applications efficiently, and analysis tools for different types of data (e.g. time-series).

## Skills

**Proficient:** Java, Linux/Bash, RDBMS/SQL, Agile/Scrum, Microsoft Office

**Competent:** Python, C++, Smalltalk, Docker, Javascript

**Familiar:** PyTorch, React, Vue, MATLAB, Rust

## Jarvis Projects

Project source code: [https://github.com/jarviscanada/jarvis_data_eng_SiddarthKrishnan](https://github.com/jarviscanada/jarvis_data_eng_SiddarthKrishnan)


**Cluster Monitor** [[GitHub](https://github.com/jarviscanada/jarvis_data_eng_SiddarthKrishnan/tree/master/linux_sql)]: Developed a monitoring program using Bash scripts and PostgreSQL for a Linux cluster to track hardware usage statistics, such as CPU, RAM, and disk. Linux servers are connected locally, and the script periodically populates a table with each node's current usage information. It was apparent that virtual memory comprises process info, memory, CPU scheduling and other statistics. Logging memory statistics was a good exercise in understanding file partitions, which manage storage space on the OS. SQL statements were embedded in our bash scripts to initialize tables inside a docker container running Postgres. We chose to run our database in docker because of its convenience for development. Lastly, we made sure to add the script that tracks host usage in our crontab because this is information that we need periodically.

**Core Java Apps** [[GitHub](https://github.com/jarviscanada/jarvis_data_eng_SiddarthKrishnan/tree/master/core_java)]:
      
  - Twitter App: Currently working on CRUD app for Twitter to learn APIs. Using HTTP and json within java.
  - JDBC App: Implemented one instance of the data persistence layer for a relational database. The client-side JDBC package java.sql was used to access RDBMS to abstract CRUD operations. The data access object (DAO) pattern was followed in java class files to execute SQL statements. The DAO pattern along with java.sql api was used in implementation to perform operations on an existing database of customers and orders. Our DAO class hides how orders are persisted in the database but can return an order using the java.sql ResultSet api. I also studied the repository pattern, its advantages, and similarities to DAO in this assignment. I leanred that the data access layer can compose objects of desired complexity through SQL joins or other statements executed in our java code with the JDBC API.
  - Grep App: Reimplemented the bash grep command in a java application. This app made use of java regex classes and file handling to test its usage for text files. The testing was done by appending lines with matching regex patterns to a single file. Furthermore, the class files and dependencies were packaged in an uber jar using maven and its shade plugin. This ensured that the JVM would find class files in both our classpath and pom file dependencies. The project was finally dockerized using a dockerfile to build the image. An interesting challenge was using streams and buffered readers to optimize heap memory usage for the application. Serialized data need not be stored like they are in java collections, and streams provide benefits of laziness which can be useful in many scenarios (cancelling data being loaded).


## Highlighted Projects
**Machine learning object recognition assignment**: Our goal was to create a machine learning model (neural network architecture) to identify objects by a class label. We wanted to understand why deep learning was preferable for computer vision tasks. We used Python and tensorflow along with a transfer learning approach, adapting a prefined CNN for our dataset. We had a hard time achieving classification lower than standard benchmarks for the R-CNN models. We could have focused more on preprocessing data and adjusting the network through drop layers. We also should have read more literature on networks for image classification as we were unable to correct overfitting and accuracy issues in the given time.


## Professional Experiences

**Junior Software Developer, Jarvis (2021-present)**: Gaining experience with many development tools and programming paradigms. Currently working in a scrum team and developing applications with linux/sql and Java. As a scrum team lead, I work with in the same role and team members while also leading meetings and keeping track of individuals' progress and impediments to success. This role involves meeting deadlines for application development and demonstrating technical acumen in code reviews upon finishing a project. I am also involved in sprint retrospectives that give our team the opportunity to evaluate our performance and discuss technical or communication imrpovements to make for following sprints.

**Cast Member, Cineplex (2021-present)**: Guest services role. Worked in concession area serving food and preparing orders. Checked vaccine certificates for all theatre entrants. Closing and opening duties.


## Education
**Ryerson University (2018-2021)**, Bachelor of Science, Computer Science
- GPA: 3.3/4


## Miscellaneous
- Receational sports
- Defi research
- Math