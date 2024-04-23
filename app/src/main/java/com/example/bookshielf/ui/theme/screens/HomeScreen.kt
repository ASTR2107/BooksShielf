package com.example.bookshielf.ui.theme.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.bookshielf.ui.theme.BooksUiState

@Composable
fun HomeScreen(
    booksUiState: BooksUiState,
    retryAction: () -> Unit,
    modifier: Modifier
){
    when (booksUiState) {
        is BooksUiState.Loading -> LoadingScreen(modifier = Modifier)
        is BooksUiState.Success -> BooksGridingInScreen(
            books = booksUiState.bookSearch,
            modifier = modifier
        )
        is BooksUiState.Error -> ErrorScreen(retryAction = retryAction, modifier)
    }
}