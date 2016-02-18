def GroupAnagrams():
    strings = initialise_anagrams()
    anagrams = {}
    for i in range(len(strings)):
        word = "".join(sorted(strings[i].lower()))
        if not anagrams.has_key(word):
            anagrams.setdefault(word, [])
        anagrams[word].append(strings[i])
    keys = anagrams.keys()
    index = 0
    for i in range(len(keys)):
        values = anagrams.get(keys[i])
        for j in range(len(values)):
            strings[index] = values[j]
            index += 1
    print strings

def initialise_anagrams():
    strings = [0]*8
    strings[0] = "abed"
    strings[1] = "later"
    strings[2] = "bead"
    strings[3] = "alert"
    strings[4] = "altered"
    strings[5] = "bade"
    strings[6] = "alter"
    strings[7] = "alerted"
    return strings

GroupAnagrams()





