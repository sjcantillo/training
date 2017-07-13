import Control.Monad

-- Read a int from input
getInts :: IO [Integer]
getInts = fmap (map read.words) getLine

fastMultiplication multiplicand multiplier
    | multiplicand == 0 = 0
    | multiplier == 0 = 0
    | otherwise = multiplicand * multiplier

main :: IO ()
main = do
    qty <- readLn

    forM_ [1 .. qty] $ \i -> do
        numbers <- getInts
        print(fastMultiplication (head numbers) (numbers!!1))
