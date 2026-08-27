# Pseudocode - Square Root Operation

FUNCTION squareRoot(number):
    IF number < 0 THEN
        THROW InvalidOperationException("Cannot take square root of a negative number")
    END IF
    RETURN Math.sqrt(number)
END FUNCTION

## Edge case explanation

If the input number is negative, there is no real-number square root, so the
function does not attempt to calculate one. Instead, it throws an
InvalidOperationException with a clear message, which propagates up to the
Main loop's try-catch block, gets logged as a warning, and the loop continues
to the next input - the program never crashes on this input.