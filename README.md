# Scrabble
This project builds an AI for Scrabble (https://en.wikipedia.org/wiki/Scrabble) 

### Resource
Available dictionary from unix OS

## Algorithm
Observation: if  a group of letters C can form a word w (usually in some order different with the order in C) then the __sorted forms of C and w must be the same__

Example: for C = [P, O, T, S] and w = SPOT, sortLetters(C) = OPST = sortLetters(w).

This equality gives us a different approach from brute-force listing all permutations and then find valid words.

+ we build a new dict/list containing only _sorted forms_ of words in the original dict. 
+	for each sorted form w_s, we also maintain a one-to-many map back to word(s) w for which sortLetters(w) = w_s (e.g. 
OPST -> {STOP, SPOT, TOPS, POST, POTS,...})
+ for each group of letters C, check if sortLetters(C) can match any sorted form in the new dict, if there is a match then we just query the word(s) C can form using the above map

## Result  
So far the implementation can generate successfully all valid words using all letters in a given group

## Next steps:
+ generate all valid words using all __subsets__ of a given group of letters
