import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Trainer {

    private String name;
    private int badges = 0;
    private List<Pokemon> pokemons = new ArrayList<>();


    public boolean hasPokemonWithElement(String element) {
        if (pokemons.size() == 0) {
            return false;
        } else return pokemons.stream().anyMatch(p -> p.getElement().equals(element));
    }

    public void winBadge()  {
        this.badges++;
    }

    public void pokemonDies ()  {
        this.pokemons = this.pokemons.stream().filter(p -> p.getHealth() > 0).collect(Collectors.toList());
    }

    @Override
    public String toString()  {
        return String.format("%s %d %d", this.name, this.badges, this.pokemons.size());
    }

    public Trainer(String name, String pokemonName, String pokemonElement, int pokemonHealth) {
        this.name = name;
        Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);
        this.pokemons.add(pokemon);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBadges() {
        return badges;
    }

    public void setBadges(int badges) {
        this.badges = badges;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }
}
