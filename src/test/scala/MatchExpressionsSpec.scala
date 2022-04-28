import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class MatchExpressionsSpec extends AnyFlatSpec with Matchers {

    "Simple Match Expression" should "print \"It's the weekend!\"" in {
        
        MatchExpressions.simpleMatch("Sunday") shouldEqual ()

    }

    "Wildcard Match" should "always print \"Today is the day\"" in {
        
        MatchExpressions.wildcardMatch("Any string can go here") shouldEqual ()

    }

    "Variable Pattern" should "print \"Today is Monday!\"" in {

        MatchExpressions.variableMatch("Monday") shouldEqual ()

    }

    "Val Match" should "print \"Today is Tuesday!\"" in {

        MatchExpressions.valMatch("Tuesday") shouldEqual ()

    }

    "Type Match" should "print \n\"Today is Monday.\"\n\"It's day 56.\"\n\"true is not a valid day.\"" in {

        MatchExpressions.typeMatch("Monday") // prints "Today is the Monday.""
        MatchExpressions.typeMatch(56) // prints "It's day 56."
        MatchExpressions.typeMatch(true) // prints "true is not a valid day."

    }

    "Deconstructing Tuples" should "print \n\"The first day of the month is a Monday\"\n\"It's Tuesday, day 2\"\n\"It's Tuesday, day 16\"\n\"Day 17\"" in {
        
        MatchExpressions.deconstructMatch(MatchExpressions.day1) 
        MatchExpressions.deconstructMatch(MatchExpressions.day2) 
        MatchExpressions.deconstructMatch(MatchExpressions.day3) 
        MatchExpressions.deconstructMatch(MatchExpressions.day4) 
    
    }

    "Pattern Alternatives" should "print \"It's the weekend!\"" in {
        
        MatchExpressions.patternAlternativeMatch("Sunday")
    
    }

    "Pattern Guards" should "print \n\"Today won’t be so long!\"\n\"It’ll be a long day today.\"" in {

        MatchExpressions.patternGuardMatch("Monday") // prints "Today won’t be so long!
        MatchExpressions.patternGuardMatch("Wednesday") // prints "It’ll be a long day today."

    }






}