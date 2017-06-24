import System.IO
import Control.Monad

-- Read coord
readCoord height = replicateM height getLine

getHorizontalNeighborn j width line 
    | (j <= width - 1) && (line!!j == '0') = j
    | j >= (width - 1) = -1
    | otherwise = getHorizontalNeighborn (j+1) width line 
    

getVericalNeighborn i j height matrix
    | i <= (height - 1) && matrix!!i!!j == '0' = i
    | i >= (height - 1) = -1
    | otherwise = getVericalNeighborn (i+1) j height matrix


main :: IO ()
main = do
    hSetBuffering stdout NoBuffering -- DO NOT REMOVE
    
    input_line <- getLine
    let width = read input_line :: Int -- the number of cells on the X axis
    input_line <- getLine
    let height = read input_line :: Int -- the number of cells on the Y axis
    
    matrix <- readCoord height
    
    forM_ [0 .. height-1] $ \i -> do
        let line = matrix!!i
        forM_ [0 .. width-1] $ \j -> do
            let elem = line!!j
            when (elem == '0') $ do 
                putStr(show j ++ " " ++ show i ++ " ")
                let neighborn = getHorizontalNeighborn (j+1) width line 
                putStr(if neighborn /= (-1) then show neighborn ++ " " ++ show i ++ " " else "-1 -1 ") 
                
                let neighborn = getVericalNeighborn (i+1) j height matrix
                putStr(if neighborn /= (-1) then show j ++ " " ++ show neighborn ++ " " else "-1 -1 ") 
                
                putStrLn " "
