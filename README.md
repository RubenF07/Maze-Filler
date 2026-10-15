# Maze-Filler

## Reflection

We had to implement a few extra methods in the map and player classes to communicate the needed information to change the game state properly. We used the LinkedChain class as it was given, and worked around it not having a peek method instead of adding one ourselves. We may need more rigorous testing before we reach a complete product, especially with the more complicated classes. Lastly, we didn't struggle much with our unknowns, and learned everything we needed to complete the prototype successfully.


## Next Steps

The MVP is largely completed. Moving forward, we intend to make the user interface cleaner, tidy up some of the code, and add certain features like doors and unique buttons. To add certain features, we may alter the Coordinate LinkedChain to contain past copies of the map instead of single altered tiles to hold a more comprehensive image of past game states.

We will need new methods and test cases for any new features and likely update existing ones as well.

Chris will likely work on improving UI while Ruben and Liam add new features if possible.

## Attribution

Main - Chris (revised by Ruben)

Map - Ruben (tested by Chris)

Player - Liam (tested by Chris)

Coordinate - Chris (tested by Chris)

TileState - Chris (tested by Chris)

LinkedChain - Course Resource

[GenAI was used as a reference on occasion, but not heavily relied on]