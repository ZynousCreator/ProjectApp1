package br.com.augustus.bookviewer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.augustus.bookviewer.ui.theme.BookViewerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BookViewerTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Home()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Livros")
                },
                navigationIcon = { IconButton(onClick = {}, content = { Icon(Icons.Default.Menu, "Icone Home") }) }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { },
                content = {
                    Icon(Icons.Filled.Edit, "Floating action button.")
                }
            )
        }
    ) { paddingValues ->
        LazyColumn(
            //paddingValues = minimum
            Modifier.padding(paddingValues).fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            items(50) { index ->
                ListItemBook("Livro $index", R.drawable.ic_launcher_foreground)
            }
        }
    }
}

@Composable
fun ListItemBook(text: String, bookCover: Int) {
    Row(
        modifier = Modifier.fillMaxWidth().height(88.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painterResource(bookCover), "Book Cover",
            modifier = Modifier.width(114.dp).height(64.dp)
        )
        Text(text)
    }
}