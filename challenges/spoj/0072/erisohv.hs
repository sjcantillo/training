import Control.Monad

-- Read a int from input
getInt :: IO Integer
getInt = readLn

-- Compute the divisors sum
sumDiv :: Integer -> Integer -> Integer
sumDiv number i
    | number == 1 = 0
    | (i*i) == number = i
    | (i*i) > number = 0
    | (i*i) < number && number `mod` i == 0 = sumDiv number (i+1) + (i + (number `div` i))
    | otherwise = sumDiv number (i+1)

-- Compute the divisors sum and save each in an array
divsum :: Integer -> [Integer]
divsum number
    | number == 1 = [0]
    | number > 1 =  divsum (number-1) ++ [sumDiv number 1]

main :: IO ()
main = do
    qty <- getInt

    forM_ [1 .. qty] $ \i -> do
        num <- getInt
        print (if num > 1 then sumDiv num 1 - num else 0)
