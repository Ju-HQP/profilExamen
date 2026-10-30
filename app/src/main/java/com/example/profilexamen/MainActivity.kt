package com.example.profilexamen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.clickable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import com.example.profilexamen.ui.theme.ProfilExamenTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProfilExamenTheme() {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ProfileScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

// Écran principal
@Composable
fun ProfileScreen(modifier: Modifier = Modifier) {
    ProfileCard(
        name = "Julien Hédreul",
        role = "Développeur Angular/React",
        description = "Étudiant en développement informatique, je pratique le Typescript avec Angular",
        skills = listOf("Kotlin", "Jetpack Compose", "Java", "JS","Angular","Symfony","ReactJS","Git"),
        availability = "Disponinible pour une alternance de 2 ans",
        onAvailabilityClick = {
            // pas de fonctionnement
        },
        // padding externe : le parent place la carte dans l'écran
        modifier = modifier
            .fillMaxWidth()
            .padding(24.dp)
    )
}

// Fiche de profil
@Composable
fun ProfileCard(
    name: String,
    role: String,
    description: String,
    skills: List<String>,
    availability: String,
    onAvailabilityClick: () -> Unit, // vide pour l'instant
    modifier: Modifier = Modifier
) {
    Surface(modifier = modifier) {
        Column(
            // padding interne
            modifier = Modifier.padding(16.dp)
        ) {
            ProfileHeader(
                name = name,
                role = role,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = description,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = "Compétences :",
                modifier = Modifier.padding(bottom = 4.dp)
            )
            skills.forEach { skill ->
                SkillItem(skill = skill)
            }
            InteractionAvailability(
                availability = availability,
                onClick = onAvailabilityClick,
                modifier = Modifier.padding(top = 12.dp)
            )
        }
    }
}

// En-tête du profil
@Composable
fun ProfileHeader(
    name: String,
    role: String,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(text = name)
        Text(text = role)
    }
}

// Une compétence
@Composable
fun SkillItem(
    skill: String,
    modifier: Modifier = Modifier
) {
    // pour afficher la compété sous forme de liste en -
    Text(
        text = "- $skill",
        modifier = modifier
    )
}

// Zone cliquable de disponibilité (action + accessibilité)
@Composable
fun InteractionAvailability(
    availability: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        color = Color.LightGray,
        modifier = modifier
            .fillMaxWidth()
            .clickable(
                role = Role.Button,
                onClick = onClick
            )
            .semantics{
                contentDescription = "Contacter : téléphone"
            }
    ) {
        Text(
            text = availability,
            modifier = Modifier.padding(12.dp)
        )
    }
}

// preview fictifs
@Preview(showBackground = true)
@Composable
fun ProfileJuniorPreview() {
    ProfilExamenTheme(){
        ProfileCard(
            name = "Jean Tanrien",
            role = "Dev junior",
            description = "Étudiant en BUT Info",
            skills = listOf("Kotlin", "Android Studio", "Java/Spring"),
            availability = "Disponible pour un stage",
            onAvailabilityClick = {},
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileFullStackPreview() {
    ProfilExamenTheme() {
        ProfileCard(
            name = "Julien Hédreul",
            role = "Développeur Angular/React",
            description = "Étudiant en développement informatique à l'ESGI, je recherche une alternance de 2ans dans le dev web/applicatif. Auriez-vous des contacts ? Si mon profil vous intéresse, je serai heureux de pouvoir échanger avec vous ;)" +
                    "Mail: hedrjul@gmail.com (tout est vrai)",
            skills = listOf("Angular", "JavaScript", "React", "MongoDB", "Symfony","SQL", "Git","PHP","Docker"),
            availability = "Disponible dès maintenant",
            onAvailabilityClick = {},
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp)
        )
    }
}