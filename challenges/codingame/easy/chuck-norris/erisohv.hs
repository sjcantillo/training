import System.IO
import Data.Char
import Numeric

-- Trim a String (font: stackoverflow)
trim = dropWhile isSpace . dropWhile isSpace

-- Transform a char to Binary
charToBinary :: Char -> String
charToBinary c 
    | length (showIntAtBase 2 intToDigit (ord c) "") < 7 = '0' : showIntAtBase 2 intToDigit (ord c) ""
    | otherwise = showIntAtBase 2 intToDigit (ord c) ""


-- Transform a string to Binary
stringToBinary :: String -> Int -> String
stringToBinary string i
    | i == (length string - 1) = charToBinary (string!!i)
    | otherwise = charToBinary (string!!i) ++ stringToBinary string (i+1)


chuckNorrisEncode :: String -> Int -> Char -> String
chuckNorrisEncode binaryArray i preBit
     | i <= (length binaryArray - 1) && binaryArray!!i == preBit =  '0' : chuckNorrisEncode binaryArray (i+1) (binaryArray!!i)
     | i <= (length binaryArray - 1) && binaryArray!!i /= preBit && binaryArray!!i == '0' = " 00 0" ++  chuckNorrisEncode binaryArray (i+1) (binaryArray!!i)
     | i <= (length binaryArray - 1) && binaryArray!!i /= preBit && binaryArray!!i == '1' = " 0 0" ++  chuckNorrisEncode binaryArray (i+1) (binaryArray!!i)
     | i == length binaryArray = ""


main :: IO ()
main = do
    hSetBuffering stdout NoBuffering -- DO NOT REMOVE

    message <- getLine
    let binMessage = stringToBinary message 0
    putStrLn (trim (chuckNorrisEncode binMessage 0 ' '))
    return ()
