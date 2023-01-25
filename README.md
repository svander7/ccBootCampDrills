# CC Boot Camp Drills

- This is alpha level software. Please expect new versions at any time.
- New versions may include even basic usage instructions!
- Suggestions [here](https://github.com/CodersCampus/ccBootCampDrills/issues/new) always appreciated.

#### Pull Requests Accepted

- Drills can always be improved
- Your pull requests are invited!

## Installation

WARNING: This installation is weird (at least for now) in that it requires 2 sibling projects installed!

#### PRE REQS

- This is designed specifically for Eclipse IDE!
- Git and Eclipse are documented elsewhere and assumed as already known and functional skills and setups

#### Sequence

These instructions are also demonstrated on [this video](http://hahyouwish.com)

1. git clone [generic-generator](https://github.com/CodersCampus/generic-generator) into your coders campus workspace
1. git clone this project into your coders campus workspace.
1. Import **Generic-Generator** as an existing maven project.
1. Run `mvn install` on the pom.xml within that project.
1. Import **ccBootCampDrills** as an existing maven project.
1. Run `mvn install` on the pom.xml within that project.

You are now ready to launch your first drill.

## Creating Your First Drill

- Finish watching a lesson such as Unit 2, Lesson 03 (AKA U2L03)
- `git checkout` the appropriate branch - TBD (this strategy is still not settled on. Units? Asssignments? other?)
- Run the `Main.main()` method in the package `lrn.cc.drill` as a java application
- type in the appropriate lesson such as u2l03 or U2L03 for Unit 2, Lesson 03
- Refresh Eclipse as instructed
- Open drill as found in `src/test/java` - it will be marked red in eclipse and in the `lrn.cc.drill.current` directory

## Running Your Drill

- Eliminate all compile errors by declaring necessary variables or similar fixes.
- Run the unit test by `Run as JUnit Test`
- Keep adjusting until your test runs green
- When complete, drag your test into the `lrn.cc.drill.done` package.

This drill is designed to resolve any questions or misunderstandings of the lesson and force at least some of it into your muscle memory!

## Repeat Until ...

- Keep creating the same drill, and completing it until ready to move on. 
- No two drills are exactly the same, so you are discouraged from copypasting, to your own benefit.

How to know when you have repeated this drill enough?

Think in terms of top speed. 

- As soon as you can repeat this drill at top speed several times in a row, you are probably ready to move on.
- Boredom is a good sign. You actually want to get a little bit bored by any drill. That means it has started to go into muscle memory.

## Frequent Pulls?

No way to know or predict future releases so it is always ideal to `git pull` before you use this, then consult this page for any changes.

## A Reminder About Suggestions and/or Better Drills

- These drills should be viewed as aids or tools, not an end in themselves.
- Don't hold back on any suggested improvements.
- Your personal point of view may be helpful for others as well!

## Git Branch Strategies

Should you care about branching this project?

- No, it will not affect your current drills.

But keep an eye on this for future strategies. We expect changes as the scope of this app evolves.