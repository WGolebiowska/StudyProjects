The project consists of 3 files:
	tests.html
	automatedTests.js
	expressions.js

tests.html includes a script for running the test function from automatedTests.js.

automatedTests.js includes automatedTest() function, which tests the speed and accuracy of addExpressions() by calling it and uses other functions from expressions.js for representing data in the desired manner.

expressions.js includes the main addExpressions() function and other functions for converting data.

About testing

        'tests' array from tests.html contains 3 subarrays, which represent respectively the first expression, the second expression, and the expected result, e.g.

        2x^2 + 3    +   3x^3 + x^2  =   3x^3 + 3x^2 + 3     are stored in

        tests[0][1]     tests[0][2]     tests[0][3]

        All terms are stored separately as elements in these subarrays, e.g.

        2x^2            +   3

        tests[0][0][0]      tests[0][0][1]

        IMPORTANT NOTE

        All terms must follow these rules:

        1) Coefficients and exponents can be any real number

        2) If coefficient or exponent is a negative number, it should be preceded with '-' sign. Don't use any parenthesis, e.g.

            -5x^-2.333      <-- OK,
            -5x^(-2.333)    <-- Wrong

        3) Coefficients of '1' and '-1' must be written explicitly, e.g.
        
            1x^2        <-- OK,
            x^2         <-- Wrong,
            -1x^5       <-- OK,
            -x^5        <-- Wrong

        4) Exponents of '1' (lone x) and '0' (constant term) also must be explicit, e.g.

            2x^1    <-- OK,
            2x      <-- Wrong,
            3x^0    <-- OK,
            3       <-- Wrong





	        Algorithm description:

            We need an array containing terms within subarrays, where the first element represents the coefficient and the second the exponent. The array must be sorted by the value of exponents decreasingly. To generate such an array from data from tests array we may use the expressionToExpressionArray(expression) function

	["2x^2", "3x^0", "3x^3", "1x^2"] --> [[3, 3], [2, 2], [1, 2], [3, 0]] (splited by 'x^' and sorted by exponents decreasingly)


            If exponents of the two following terms are different, it means that the first one is the last of its exponent and it's copied to the result array.
            If exponents of the two following terms are the same, add the first one to the second and skip copying. The next term might be also of the same exponent.
            When you reach two different terms, where the first is the sum of all previous terms of the same exponent, copy it to the result array.

            The last term in expressionArray represents the sum of coefficients of the lowest exponent of the expression and it is copied to the result array explicitly.

            E.g.

            expressionArray                                 result
            [[3, 3], [2, 2], [1, 2], [3, 0]]                []
            
            [3, 3] != [2, 2]                                [[3, 3]]

            [2, 2] == [1, 2]    --> [2, 2] = [2+1, 2]       [[3, 3]]

            [3, 2] != [3, 0]                                [[3, 3], [3, 2]]

            []                                              [[3, 3], [3, 2], [3, 0]]


            To convert result array into expressionArray, you can use expressionArrayToExpression(expressionArray) function.
            To get a string representation of the whole expression from expressionArray, use getStringExpression().


======================ADDITIONAL TASK=========================

In expressions.js there is an implementation of function for converting human readable mathematical expression to array of expressions, e.g.

"3x^3 + 2x^2 - x^4 + x^0.2 - 2x^(-5.1) + 4 - 3"    --> [[3x^3], [2x^2], [-1x^4], [1x^0.2], [-2x^-5.1], [4x^0], [-3x^0]]

It is not 100% complete and it looks pretty terrible, but my time is about to finish. It can be used for user input. :)