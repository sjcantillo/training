import System.IO
import Control.Monad
import Data.List
import Data.Maybe

main :: IO ()
main = do
    hSetBuffering stdout NoBuffering -- DO NOT REMOVE
    
    -- The while loop represents the game.
    -- Each iteration represents a turn of the game
    -- where you are given inputs (the heights of the mountains)
    -- and where you have to print an output (the index of the mountain to fire on)
    -- The inputs you are given are automatically updated according to your last actions.
    
    loop

readMontains = replicateM 8 $ do
        line <- getLine
        let mountainh = read line :: Int -- represents the height of one mountain.
        return mountainh


loop :: IO ()
loop = do
    arrayMontains <- readMontains
    let max = (maximum arrayMontains)
    let index = fromJust $ (elemIndex max arrayMontains)

    -- The index of the mountain to fire on.
    print (index)
    
    loop
