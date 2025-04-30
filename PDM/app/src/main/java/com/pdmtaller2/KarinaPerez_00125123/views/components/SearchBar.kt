package com.pdmtaller2.KarinaPerez_00125123.views.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun SearchBar(
    text: String,
    onTextChange: (String) -> Unit,
    onSearch: () -> Unit,
    modifier: Modifier = Modifier,
    placeholder: String = "Buscar..."
) {
    TextField(
        value = query,
        onValueChange = onTextChange,
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
        placeholder = { Text(placeholder) },
        leadingIcon = {
            Icon(imageVector = Icons.Default.Search, contentDescription = "Search Icon")
        },
        trailingIcon = {
            if (query.isNotEmpty()) {
                IconButton(onClick = { onTextChange("") }) {
                    Icon(imageVector = Icons.Default.Close, contentDescription = "Clear Icon")
                }
            }
        },
        singleLine = true,
        shape = RoundedCornerShape(16.dp),
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = MaterialTheme.colorScheme.surface,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Search),
        keyboardActions = KeyboardActions(onSearch = { onSearch()})
        )
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun SearchBarPreview(){
    SearchBar()
}