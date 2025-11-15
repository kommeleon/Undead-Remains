# Guidelines for Creating new Blocks:

## Don't forget to register the new block in _item\ModCreativeModeTabs.java_
## Don't forget to add the texture or a placeholder for it.

### If you are adding an advanced Block:
- Create a new java file _block\custom_
- Copy boilerplate code from another file, so it doesn't crash.
- After that proceed as normal.

### You have to register the file in _ModBlocks.java_:
- You can just copy a registration from another file
- You still have to modify the registration to match the new file.

### For item loot:
- Open datagen\loot\ModBlockLootTables.java:
- copy code from similar block.
- If needed create a new loot table from ground up.

### In _ModBlockStateProvider_:
-Copy from similar block

## Recommended additions:
Add item tags in _ModBlockTagGenerator_

#### In ModItemTagGenerator:
- Add the tags here too.
- Don't forget following, because blocks are not items.: .add(ModBlocks.MYBLOCK.get().asItem())

Add recipes in _ModRecipeProvider_
