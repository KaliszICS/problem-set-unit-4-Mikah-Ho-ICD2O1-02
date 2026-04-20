[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/6bpFHcIm)
[![Open in Codespaces](https://classroom.github.com/assets/launch-codespace-2972f46106e565e64193e422d61a12cf1da4916b45550586e14ef0a7c637dd04.svg)](https://classroom.github.com/open-in-codespaces?assignment_repo_id=23643964)
# Instructions  

# Create a High-Low guessing Game:

You will have 3 options each with a maximum amount of marks they can get.

# Option 1: Basic Game (80%)

Create a high-low guessing game where the user will guess if a number is higher or lower than the number 10.

The program must follow the following specifications:

Display a welcome message.

Ask the user for the number of rounds like they would like play.

Display the current round number.

Give the user the options of High, Low or Even.  It is recommended to make it so they enter numbered options to choose.

Example Menu:

		1. High (11 to 20)
		2. Low (0 to 9)
		3. Even(10)

Once they have chosen, pick a random number from 0-20 (including 0 and 20).  

Output the number.  

If they are right give them one point.  

If they are wrong do not.

Make sure to output their current score after each round.

At the end of all their rounds, output their total score.  If they got more than or equal to half the guesses right, tell them they won (and their score compared to the total guesses)!  Otherwise better luck next time (Still display their score compared to total guesses).

Do not forget to comment and document your code! 

Example Run:


		Welcome to the High Low Guessing Game.
		
		Input a number of rounds to play: 2
	
		Round 1:
	
		Please select High, Low or Even:
		1. High (11 to 20)
		2. Low (0 to 9)
		3. Even(10)
	
		3
	
		The number was 11.  You were incorrect.
		Current Score: 0

 		Round 2:

		Please select High, Low or Even:
		1. High (11 to 20)
		2. Low (0 to 9)
		3. Even(10)
	
		3

 		The number was 10, You were correct.
	 	Current Score: 1

		Total Score: 1
		Congratulations you got 1 out of 2 rounds right!

	

# Option 2: Input Validation (+10%)

Do all the follow as above but add one extra feature.

Check if all input is valid.  They cannot input negative numbers or numbers outside of the range of the menu.

Example Run:


		Welcome to the High Low Guessing Game.

		Input a number of rounds to play: 0

		Invalid Input!
 		Input a number of rounds to play: 3
	
		Round 1:
	
		Please select High, Low or Even:
		1. High (11 to 20)
		2. Low (0 to 9)
		3. Even(10)
	
		3
	
		The number was 11.  You were incorrect.
		Current Score: 0

 		Round 2:

		Please select High, Low or Even:
		1. High (11 to 20)
		2. Low (0 to 9)
		3. Even(10)

 		0

		Invalid Input!
		Please select High, Low or Even:
		1. High (11 to 20)
		2. Low (0 to 9)
		3. Even(10)
	
		3

 		The number was 10, You were correct.
	 	Current Score: 1

		Round 3:
	
		Please select High, Low or Even:
		1. High (11 to 20)
		2. Low (0 to 9)
		3. Even(10)
	
		1
	
		The number was 15.  You were correct.
		Current Score: 2

		Total Score: 2
		Congratulations you got 2 out of 3 rounds right!

# Option 3: Changeable Range (+10%)

In Option 3, Do all of the above options plus ask the user what the lowest and highest number they want to use are.  Create the high low guessing game based on the provided range.

For example if the range uses -5 and 5 as the two values, 0 would be even, -1 to -5 would be low, and 1 to 5 would be high.

In the event of the even value being a fraction (.5), use both numbers above and below as even.

Example Run:


		Welcome to the High Low Guessing Game.
		
		Input a number of rounds to play: 0

		Invalid Input!
 		Input a number of rounds to play: 2

		What Range would you like to play between (#-#)?
		-5-5
	
		Round 1:
	
		Please select High, Low or Even:
		1. High (1 to 5)
		2. Low (-1 to -5)
		3. Even(0)
	
		3
	
		The number was 1.  You were incorrect.
		Current Score: 0

 		Round 2:

		Please select High, Low or Even:
		1. High (1 to 5)
		2. Low (-1 to -5)
		3. Even(0)

 		0

		Invalid Input!
		Please select High, Low or Even:
		1. High (1 to 5)
		2. Low (-1 to -5)
		3. Even(0)
	
		1

 		The number was -4, You were incorrect.
	 	Current Score: 0

		Total Score: 0
		You got 0 out of 2 correct.  Better Luck next time.
