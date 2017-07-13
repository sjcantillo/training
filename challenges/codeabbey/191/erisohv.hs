import Control.Monad
import Data.Char

readInts :: IO String
readInts = fmap (map read.words) getLine

-- Swap 2 elements in a list (font: https://stackoverflow.com/questions/10133361/haskell-replace-element-in-list)
swapListElements weights i j = do
    let swap1 = take i weights ++ [weights!!j] ++ drop (i + 1) weights
    let swap2 = take j swap1 ++ [weights!!i] ++ drop (j + 1) swap1
    swap2

-- Return true if the array value in posFrom is greater than the value in posTo
isMaxValuePosition array posFrom posTo = array!!posFrom >= array!!posTo

-- Return true if the array value in posFrom is less than the value in posTo
isMinValuePosition array posFrom posTo =
    if posFrom >= 0 then
        array!!posFrom <= array!!posTo
    else
        array!!posFrom /= 0 && array!!posFrom <= array!!posTo

-- Return true if the array value in posFrom is less than the value in posTo and is not 0
isMinValuePositionNotZero array posFrom posTo = array!!posFrom /= 0 && array!!posFrom <= array!!posTo

-- Search the optimal value position in the array, according to the compareFunction
getOptimalPosition weights pos optPos compareFunction
    | pos == length weights-1 && length weights > 2 && optPos == 0 = getOptimalPosition weights 1 1 compareFunction
    | pos == length weights-1 && compareFunction weights pos optPos =  pos
    | pos == length weights-1 = optPos
    | compareFunction weights pos optPos = getOptimalPosition weights (pos + 1) pos compareFunction
    | otherwise = getOptimalPosition weights (pos + 1) optPos compareFunction

-- Resturn true if the valFrom > valTo
isMax valFrom valTo = valFrom > valTo

-- Return true if the valFrom < valTo
isMin valFrom valTo = valFrom < valTo

-- Combine the optVal through the array positions to find the better value according to the compareFunction
getValue weights posAct posFrom optVal compareFunction
    | posAct == length weights-1 = optVal
    | posAct == 0 && weights!!posFrom == '0' = getValue weights (posAct + 1) posFrom optVal compareFunction -- First cannot be 0
    | posAct == length weights-1 && compareFunction(swapListElements weights posAct posFrom) optVal = swapListElements weights posAct posFrom
    | compareFunction(swapListElements weights posAct posFrom) optVal =
        getValue weights (posAct + 1) posFrom (swapListElements weights posAct posFrom) compareFunction
    | otherwise = getValue weights (posAct + 1) posFrom optVal compareFunction

getMinValue weights weightsString minPos = do
    let min0 = getValue weightsString 0 minPos weightsString isMin -- minimum = 0
    -- Search for minimum /= 0
    let minPosN = getOptimalPosition weights 0 0 isMinValuePositionNotZero
    let minN = getValue weightsString 0 minPosN weightsString isMin
    --minN
    if min0 < minN then min0 else minN

main = do
    num <- readLn
    forM_ [1 .. num] $ \i -> do
        line <- getLine :: IO String
        let stringW = line :: String
        let weights = map digitToInt line
        let minPos = getOptimalPosition weights 0 0 isMinValuePosition
        let maxPos = getOptimalPosition weights 0 0 isMaxValuePosition


        if minPos == 0 then
           putStr (line ++ " ")
        else
           putStr (getMinValue weights stringW minPos ++ " ")

        if maxPos == 0 then
           putStr (line ++ " ")
        else
           putStr (getValue stringW 0 maxPos stringW isMax ++ " ")
