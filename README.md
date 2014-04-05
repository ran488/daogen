daogen
======

Old side project (circa 2005-06) written in Java (Swing) to reverse engineer a DB and generate JDBC DAO's and VO's. Uses JDBC meta data from a running database to reverse engineer tables, then binds the data to Velocity templates to create DAO interfaces and implementation classes, VO's, a DaoFactory class, and a ResourceManager class. 

Also includes the ability to run ad hoc queries against the database, and to create custom methods for DAO's. If you add them to this tool instead of hte generated code, then they won't be lost if you have to regenerate the code from the database.

The templates should/could be updated to make the resulting code cleaner. I haven't used this in years, so the first thing I would do is run the generated code through FindBugs, PMD, and Fortify to see what those pick up. Instead of fixing the resulting code, go back and fix the templates. 

I recently updated build to use Gradle (using the 'application' plugin) and generate the distribution. Note that some JDBC drivers are not available in public repo's (e.g. Oracle), so you may need to provide your own.

To create a distribution complete with batch or shell script to launch:

% gradlew distZip

% gradlew distTar

or to run....

% gradlew run


This was originally developed against Oracle, but has been used successfully against MySQL and TeraData (though lack of PK complicates things for Teradata). I haven't used Teradata or MySQL in quite a few years, so I'm not sure if these templates are functional at all. The Oracles ones should mostly be OK.

This project does not have any working unit tests (it used to, but I can't find them), and the generated code does not include unit tests to exercise it. If I were to start using this again, that would be the first thing I work on. Also, I just ran FindBugs against this code base for the first time, and, well, it's ugly. Functional, but ugly.