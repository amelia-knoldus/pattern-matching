/* Match Expressions and Pattern Matching in Scala */
/* Match expressions in Scala are comparable to switch statements in JavaScript or Java */

/* 

Example of switch statement in JavaScript. Compare with simpleMatch in Scala below

function switchJavaScript(today) {
  switch(today) {
    case "Monday":
        console.log("It's Monday! It's going to be a great week!");
        break;
    case "Tuesday":
        console.log("Taco Tuesday!");
        break;
    case "Wednesday":
        console.log("It's Wednesday, get over that hump!");
        break;
    case "Thursday":
      console.log("It's Thursday! Friday's around the corner!");
        break;
    case "Friday":
        console.log("TGIF!");
        break;
    case "Sunday":
    case "Saturday":
        console.log("It's the weekend!");
        break;
    default:
       console.log("Not a valid day.");
    }
}

switchJavaScript("Thursday"); // prints "It's Thursday! Friday's around the corner!"

*/

object MatchExpressions {
    println("\n========== Match Expressions and Pattern Matching ==========\n")

    // SIMPLE MATCH
    //   simple match expression. See the equivalent switch statement in JavaScript above.

    def simpleMatch(dayInput: String): Unit = dayInput match {
        
        case "Monday" => println("It's Monday! It's going to be a great week!")
        case "Tuesday" => println("Taco Tuesday!")
        case "Wednesday" => println("It's Wednesday, get over that hump!")
        case "Thursday" => println("It's Thursday! Friday's around the corner!")
        case "Friday" => println("TGIF!")
        case "Saturday" => println("It's the weekend!")
        case "Sunday" => println("It's the weekend!")
        case _ => println("Not a valid day.")
    }

    // simpleMatch("Sunday") // prints "It's the weekend!"


    /* ------------------------------------------------------- */


    // WILDCARD MATCH
    //   an underscore ` _ ` is the wildcard pattern. The wildcard pattern will match any input
    //   the following function `wildcardMatch` will always print "Today is the day!"
    //   often used as the final case as a "catch-all"
    //   note that the wildcard pattern cannot be referenced in the return statement so the following is invalid:
        
    /*

        def wildcardMatch(dayInput: String): Unit = dayInput match {
            case _ => println(s"Today is $_!") // invalid
        }

        wildcardMatch("Monday")  // will not compile  

    */

    def wildcardMatch(dayInput: String): Unit = dayInput match {
        case _ => println("Today is the day!")
    }

    
    // wildcardMatch("Any string can go here") // will always print "Today is the day"


    /* ------------------------------------------------------- */


    // VARIABLE PATTERN
    //   the variable pattern allows you to capture and use the input in the return statement
    //   use any variable name beginning with a lowercase letter
    //   will match any input

    def variableMatch(dayInput: String): Unit = dayInput match {
        case dayInput => println(s"Today is $dayInput!")
    }

    // variableMatch("Monday") // prints "Today is Monday!"


    /* ------------------------------------------------------- */

    // STABLE IDENTIFIERS
    //   stable identifiers are used to match with any constant input such as strings, ints, etc.

    def stableIdentifierMatch(dayInput: Any): Unit = dayInput match {
        case "Monday" => println("Today is Monday!")
        case 2 => println("Today is Tuesday!")
    }

    // stableIdentifierMatch("Monday") // prints "Today is Monday!"
    // stableIdentifierMatch(2) // prints "Today is Tuesday!"

    // to match with a val, you must enclose the name of the val in back ticks like so `valName` 
    //    otherwise it is interpreted as a variable pattern (see above) which will match any input

    val monday = "Monday"
    val tuesday = "Tuesday"

    def valMatch(dayInput: String): Unit = dayInput match {
        case `monday` => println("Today is Monday!") // these will match against the vals above
        case `tuesday` => println("Today is Tuesday!") // ^
    }

    // valMatch("Tuesday") // prints "Today is Tuesday!"

    // careful! don't forget the backticks!
    //   the following function will always print "Today is Monday!", it won't try to match our vals above
    //   valMatchIncorrect("Tuesday") // will always print "Today is Monday!" 

    def valMatchIncorrect(dayInput: String): Unit = dayInput match {
        case monday => println("Today is Monday!")
        case tuesday => println("Today is Tuesday!")
    }


    /* ------------------------------------------------------- */


    // TYPE MATCHING
    //   you can use pattern matching to match only the type of the input, as seen below:

    def typeMatch(dayInput: Any): Unit = dayInput match {
        case string: String => println(s"Today is $string.")
        case num: Int => println(s"It's day $num.")
        case _ => println(s"$dayInput is not a valid day.")
    }

    // typeMatch("Monday") // prints "Today is the Monday.""
    // typeMatch(56) // prints "It's day 56."
    // typeMatch(true) // prints "true is not a valid day."


    /* ------------------------------------------------------- */


    // DECONSTRUCTING TUPLES
    //   tuples can be deconstructed to match one or more elements in the tuple
    //   tuple patterns can be combined with other match patterns (eg. wildcard, variable, stable identifiers, etc.).
    
    val day1 = ("Monday", 1)
    val day2 = ("Tuesday", 2)
    val day3 = ("Tuesday", 16)
    val day4 = ("Wednesday", 17)

    def deconstructMatch(dayInput: Any): Unit = dayInput match {
        case (day, 1) => println(s"The first day of the month is a $day")
        case ("Tuesday", num) => println(s"It's Tuesday, day $num.")
        case (_, num) => println(s"Day $num.")
        case _ => println("Not a valid day.")
    }

    // deconstructMatch(day1) // prints "The first day of the month is a Monday"
    // deconstructMatch(day2) // prints "It's Tuesday, day 2"
    // deconstructMatch(day3) // prints "It's Tuesday, day 16"
    // deconstructMatch(day4) // prints "Day 17"


    /* ------------------------------------------------------- */


    // PATTERN ALTERNATIVE
    //   a pipe character ` | ` can be used to provide pattern alternatives, much like an OR expression

    def patternAlternativeMatch(dayInput: String): Unit = dayInput match {
        case "Monday" | "Tuesday" | "Wednesday" | "Thursday" | "Friday" => println("It's a weekday!")
        case "Saturday" | "Sunday" => println("It's the weekend!")
        case _ => println("Not a valid day.")
    }

    // patternAlternativeMatch("Sunday") // prints “It's the weekend!”


    /* ------------------------------------------------------- */


    // PATTERN GUARDS
    //   a case can be followed by ` if `some condition` ` to match input only if a certain condition is met

    def patternGuardMatch(dayInput: String) = dayInput match {
        case day if day.length > 6 => println("It'll be a long day today.")
        case day if day.length <= 6 => println("Today won't be so long!")
    }
        
    // patternGuardMatch("Monday") // prints "Today won’t be so long!
    // patternGuardMatch("Wednesday") // prints "It’ll be a long day today."
    
}