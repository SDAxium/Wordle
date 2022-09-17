# CodePath Project 1 - Wordle

Submitted by: **Mamadou Diallo**

**Wordle** is a simple wordle clone. Users have three chances to guess a four letter word.  

Time spent: **7** hours spent in total

## Required Features

The following **required** functionality is completed:

* [ ] User has 3 chances to guess a random 4 letter word
* [ ] After 3 guesses, user should no longer be able to submit another guess
* [ ] After each guess, user sees the "correctness" of the guess
* [ ] After all guesses are taken, user can see the target word displayed 

The following **optional** features are implemented:

* [ ] User can tap a 'Reset' button to get a new word and clear previous guesses

## Video Walkthrough

Here's a walkthrough of implemented features:

<img src='https://i.imgur.com/Yq2E8Yo.gif' title='Video Walkthrough' width='' alt='Video Walkthrough' />

GIF created with Screen Record(android)   


## Notes
- Random word generator showed an index out of bounds out of nowhere. After changing the random generation slightly, the first word would always be the same upon opening the app. Changed the function to shuffle the array then pick a random word from it 

## License

    Copyright [2022] [Mamadou Diallo]

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
