# CC Boot Camp Drills

Please feel free to also consult [this explainer](https://resources.coderscampus.com/docs/drills/explainer/) for more info

#### ALWAYS PULL THE LATEST FROM GIT BEFORE RUNNING DRILLS!!!!
- This is alpha level software. Please expect new versions at any time.
- New versions may include even basic usage instructions!
- Repeating for emphasis: ALWAYS PULL THE LATEST FROM GIT BEFORE RUNNING DRILLS!!!!

## Installation

#### PRE REQS

- a git client - either Github Desktop or the shell version or ...
- an IDE such as (Eclipse or IntelliJ free version) 
- the above are documented elsewhere and assumed as already known and functional skills and setups

If you are just starting the course and you have never cloned a project or imported a project into an IDE and run it before, this is a very natural place to be. There is no shame in asking for help from either a foundations instructor, or another friendly bootcamper.

#### Sequence

These instructions are also demonstrated on [this video](http://hahyouwish.com) EXCEPT THE INSTALL IS SHOWN WRONG ON THIS VIDEO.

1. git clone this project into your coders campus workspace. 
2. if Eclipse import as either Maven project or existing Eclipse project
3. if IntelliJ Open should work, but if it does not Open natively, then Open as Maven project
1. if Eclipse and anything is not compiling or running properly, then run `mvn install` on the pom.xml within this project

You are now ready to launch your first drill.

## Creating Your First Drill

You are expected to have watched the video on a lesson and to have completed all other drills and videos before that lesson.

- Finish watching a lesson such as Unit 2, Lesson 03 (AKA U2L03) 
- Run the `Main.main()` method in the package `com.coderscampus` as a java application
- Every drill asks if you want to also launch online help in the browser. "y" for the first one, or just hit enter after you already have it open.
- Type in the appropriate lesson such as U2L03 or u2l03 for Unit 2, Lesson 03 (not case sensitive).
- Refresh Eclipse as instructed if Eclipse is your IDE.
- Open drill as found in `src/test/java` - it will typically be marked red in Eclipse and in the `lrn.cc.drill.current` directory. 

## Running Your Drill

- Eliminate all compile errors by declaring necessary variables or similar fixes as described in the docs listed in https://resources.coderscampus.com/docs/drills/
- Run the unit test by right clicking on the test file and `Run as JUnit Test`
- Keep adjusting until your test runs green. Again, follow instructions on docs or seek help as appropriate.

This drill is designed to resolve any questions or misunderstandings of the lesson and force at least some of it into your muscle memory!

## Repeat Until ...

- Keep creating the same drill, and completing it until ready to move on. 
- A random name generator means no two drills are exactly the same, so you are discouraged from copypasting, to your own benefit.

How to know when you have repeated this drill enough? Think in terms of top speed. 

- _**As soon as you can repeat this drill at top speed several times in a row,**_ you are probably ready to move on.
- Boredom is a good sign. You actually want to repeat enough to get a little bored by any drill. That means it has started to go into muscle memory.

## A Reminder About Suggestions and/or Better Drills

- These drills should be viewed as aids or tools, not an end in themselves.
- Don't hold back on any suggested improvements.
- Your personal point of view may be helpful for others as well!
-

#### Pull Requests Accepted

- Suggestions [here](https://github.com/CodersCampus/ccBootCampDrills/issues/new) always appreciated.
- Drills can always be improved
- Your pull requests are invited!
