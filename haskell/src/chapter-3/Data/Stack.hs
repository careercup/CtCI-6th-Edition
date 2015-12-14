module Data.Stack where

data Stack a = Stack [a]
  deriving (Eq, Show)

push :: a -> Stack a -> Stack a
push a (Stack xs) = Stack (a:xs)

pop :: Stack a -> Stack a
pop (Stack (x:xs)) = Stack xs
pop (Stack []) = Stack []

peek :: Stack a -> Maybe a
peek (Stack (x:xs)) = Just x
peek (Stack []) = Nothing

isEmpty :: Stack a -> Bool
isEmpty (Stack []) = True
isEmpty (Stack xs) = False

mkStack :: a -> Stack a
mkStack a = Stack [a]


