package com.example.healthyfitness.presentation.screens.recipe_details_screen.preview_data

import com.example.healthyfitness.presentation.screens.recipe_details_screen.model.IngredientUiModel
import com.example.healthyfitness.presentation.screens.recipe_details_screen.model.RecipeDetailsUiModel


val fakeIngredients = listOf(
    IngredientUiModel(
        name = "chives",
        amount = "2",
        unit = "servings",
        image = "butter-sliced.jpg"
    ), IngredientUiModel(
        name = "butter",
        amount = "0.25",
        unit = "cup",
        image = "fresh-chives.jpg"
    ), IngredientUiModel(
        name = "cream",
        amount = "2",
        unit = "Tbsp",
        image = "fluid-cream.jpg"
    ), IngredientUiModel(
        name = "egg yolks",
        amount = "3",
        unit = "egg yolks",
        image = "egg-yolk.jpg"
    ), IngredientUiModel(
        name = "eggs",
        amount = "4",
        unit = "eggs",
        image = "egg.png"
    ), IngredientUiModel(
        name = "muffins",
        amount = "2",
        unit = "muffins",
        image = "English-muffins.jpg"
    ), IngredientUiModel(
        name = "black pepper",
        amount = "2",
        unit = "servings",
        image = "pepper.jpg"
    ), IngredientUiModel(
        name = "lemon juice",
        amount = "2",
        unit = "Tbsp",
        image = "lemon-juice.jpg"
    ), IngredientUiModel(
        name = "salt",
        amount = ".5",
        unit = "Tsp",
        image = "salt.jpg"
    ), IngredientUiModel(
        name = "vinegar",
        amount = "1",
        unit = "tsp",
        image = "vinegar-(white).jpg"
    )
)

val fakeRecipeDetails = RecipeDetailsUiModel(
    name = "Meatless Eggs Benedict",
    imageUrl = "https://img.spoonacular.com/recipes/646982-556x370.jpg",
    ingredients = fakeIngredients,
    nutrition = mapOf(
        "KCal" to "605",
        "fats" to "45g",
        "carb" to "29g",
        "proteins" to "20g"
    ),
    instructions = listOf(
        "Bring a shallow pan of water and the vinegar to a boil." +
                "To poach the eggs, break each egg into a cup, and slide into the boiling water." +
                " By putting it in a cup first, it keeps the eggs neater in the boiling water." +
                "Cook for about 2-3 minutes, remove with a slotted spoon and drain on a towel." +
                "Toast the English muffins." +
                "For the hollandaise sauce, put the egg yolks," +
                " lemon juice and salt in a food processor and blend until smooth." +
                "Melt the butter in a pan on a very low flame," +
                " then add it to the food processor and blend until well mixed.",
        "Place the sauce in a double boiler and simmer for 2-3 minutes," +
                " stirring it constantly- so it doesn't start to clump and turn into scrambled eggs." +
                " (If you don't have a double boiler- like me- put it in a non-stick pan and make the flame super low." +
                " Pay extra attention to constantly stirring it." +
                "Stir in the cream and season with pepper",
        "Place a poached egg on each muffin slice and top with the sauce and chopped fresh chives."
    )
)
