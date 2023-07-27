package br.com.alexfelipe.authapp.ui.screens

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import br.com.alexfelipe.authapp.models.Product
import br.com.alexfelipe.authapp.ui.theme.AuthAppTheme
import coil.compose.AsyncImage
import java.math.BigDecimal
import kotlin.random.Random

@Composable
fun MainScreen(user: String) {
    val products = sampleProducts(20)
    Column {
        Box(
            Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(text = "Olá, $user")
        }
        LazyColumn {
            items(products) { product ->
                Column(
                    Modifier
                        .padding(8.dp)
                        .clip(shape = RoundedCornerShape(10.dp))
                        .border(
                            width = 1.dp,
                            color = Color.Gray.copy(alpha = 0.5f),
                            shape = RoundedCornerShape(10.dp)
                        )
                ) {
                    AsyncImage(
                        product.image,
                        contentDescription = "product image",
                        Modifier
                            .padding(8.dp)
                            .clip(shape = RoundedCornerShape(10.dp))
                            .fillMaxWidth()
                            .height(100.dp),
                        placeholder = ColorPainter(Color.Gray),
                        contentScale = ContentScale.Crop
                    )
                    Text(text = product.name, Modifier.padding(8.dp))
                    Text(
                        text = product.price.toPlainString(),
                        Modifier.padding(8.dp)
                    )
                }
            }
        }
    }

}

private fun sampleProducts(amount: Int) =
    List(amount) {
        Product(
            name = LoremIpsum(
                Random.nextInt(
                    2, amount
                )
            ).values.first(),
            price = BigDecimal(it * 1.5),
            image = "https://picsum.photos/${
                Random.nextInt(
                    1280,
                    1920
                )
            }/${
                Random.nextInt(
                    720,
                    1080
                )
            }"
        )
    }

@Preview
@Composable
fun MainScreenPreview() {
    AuthAppTheme {
        Surface(
            Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            MainScreen("alex")
        }
    }
}