package com.chh.compose.feature.pokemon.detail.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chh.compose.core.designsystem.theme.AACComposeTheme
import com.chh.compose.core.designsystem.utils.getPokemonColor
import com.chh.compose.core.designsystem.utils.getPokemonPainter
import com.chh.compose.core.model.Type

@Composable
fun PokemonTypeCard(
    index: Int,
    type: Type,
    onTypeClick: (Type) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .padding(top = 5.dp, bottom = 5.dp)
            .fillMaxSize()
            .height(80.dp)
            .background(color = getPokemonColor(type.name))
            .clickable { onTypeClick(type) },
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = modifier.weight(1f),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = getPokemonPainter(type.name),
                contentDescription = type.name,
                modifier = modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(Color.White),
                tint = getPokemonColor(type.name)
            )
        }

        CardDivider(index)

        Text(
            text = type.name.uppercase(),
            modifier = modifier.weight(1f),
            color = Color.White,
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.titleLarge
        )
    }
}

@Preview(
    widthDp = 400,
    heightDp = 80
)
@Composable
private fun PokemonTypeCardPreview() {
    AACComposeTheme {
        PokemonTypeCard(
            index = 0,
            type = Type("grass"),
            onTypeClick = {}
        )
    }
}
