import System.IO
import Control.Monad
import Data.Map
import qualified Data.List as List
import Data.Ord
import Data.Maybe

points = [('e', 1), ('a', 1), ('i', 1), ('o', 1), ('n', 1), ('r', 1), ('t', 1), ('l', 1), ('s', 1), ('u', 1),
         ('d', 2), ('g', 2), ('b', 3), ('c', 3), ('m', 3), ('p', 3), ('f', 4), ('h', 4), ('v', 4), ('w', 4),
         ('y', 4), ('k', 5), ('j', 8), ('x', 8), ('q', 10), ('z', 10)]

-- Return the letter points 
getPoints letter = fromList points ! letter

--counts the ocurences of a particular letter (font: https://wiki.haskell.org/Stupid_Curry_Tricks)
countLetters :: Char -> String -> Int
countLetters target str = length (List.filter ( == target) str)

-- Calculate the word points
getWordPoints :: String -> Int
getWordPoints word = sum (Prelude.map getPoints word)

-- Calculate the points from a word list
calculatePoints :: [String] -> [Int]
calculatePoints = Prelude.map getWordPoints

-- Get the position with the max points
getMaxWordPosition wordsPoints = fromJust (List.elemIndex (maximum wordsPoints) wordsPoints)
    
-- Compare the letters set with the words to find the matchers words
isMatch letters word i 
    | countLetters (word!!i) word > countLetters (word!!i) letters = False
    | (word!!i) `notElem` letters = False
    | i == length word - 1 && elem (word!!i) letters =  True
    | otherwise = isMatch letters word (i+1)

--
getMatchingWords :: String -> [String] -> Int -> [String]
getMatchingWords letters words i
    | i == (length words - 1) && isMatch letters (words!!i) 0 = [words!!i]
    | i == (length words - 1) && not (isMatch letters (words!!i) 0) = []
    | i < (length words - 1) && isMatch letters (words!!i) 0 =(words!!i) : getMatchingWords letters words (i+1)
    | otherwise = getMatchingWords letters words (i+1)

--
readWords n = replicateM n getLine

-- 
main :: IO ()
main = do
    hSetBuffering stdout NoBuffering -- DO NOT REMOVE
    input_line <- getLine
    let n = read input_line :: Int
    words <- readWords n
    letters <- getLine
    
    let filterWords = List.filter (\x-> length x <= length letters) words
    let matches = getMatchingWords letters filterWords 0
    let pointsArray = calculatePoints matches
    
    let max = getMaxWordPosition pointsArray

    putStrLn (matches!!max)
    return ()
    
