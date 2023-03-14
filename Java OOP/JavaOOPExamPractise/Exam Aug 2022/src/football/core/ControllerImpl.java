package football.core;


import football.entities.field.ArtificialTurf;
import football.entities.field.Field;
import football.entities.field.NaturalGrass;
import football.entities.player.Men;
import football.entities.player.Player;
import football.entities.player.Women;
import football.entities.supplement.Liquid;
import football.entities.supplement.Powdered;
import football.entities.supplement.Supplement;
import football.repositories.SupplementRepository;
import football.repositories.SupplementRepositoryImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import static football.common.ConstantMessages.*;
import static football.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {

    private SupplementRepository supplements;
    private Collection<Field> fields;

    public ControllerImpl() {
        this.supplements = new SupplementRepositoryImpl();
        this.fields = new ArrayList<>();
    }

    @Override
    public String addField(String fieldType, String fieldName) {
        Field field;

        switch (fieldType)  {
            case "ArtificialTurf":
                field = new ArtificialTurf(fieldName);
                break;
            case "NaturalGrass":
                field = new NaturalGrass(fieldName);
                break;
            default:
                throw new NullPointerException(INVALID_FIELD_TYPE);
        }

        fields.add(field);
        return String.format(SUCCESSFULLY_ADDED_FIELD_TYPE, fieldType);
    }

    @Override
    public String deliverySupplement(String type) {
        Supplement supplement;

        switch (type)  {
            case "Powdered":
                supplement = new Powdered();
                break;
            case "Liquid":
                supplement = new Liquid();
                break;
            default:
                throw new IllegalArgumentException(INVALID_SUPPLEMENT_TYPE);
        }

        supplements.add(supplement);
        return String.format(SUCCESSFULLY_ADDED_SUPPLEMENT_TYPE, type);
    }

    @Override
    public String supplementForField(String fieldName, String supplementType) {
        if (supplements.findByType(supplementType) == null) {
            throw new IllegalArgumentException(String.format(NO_SUPPLEMENT_FOUND, supplementType));
        }

        Field field = fields.stream().filter(e -> e.getName().equals(fieldName)).findFirst().orElse(null);
        Supplement supplement;

        switch (supplementType)  {
            case "Powdered":
                supplement = new Powdered();
                break;
            case "Liquid":
                supplement = new Liquid();
                break;
            default:
                throw new NullPointerException(INVALID_SUPPLEMENT_TYPE);
        }

        assert field != null;
        field.addSupplement(supplement);
        supplements.remove(supplement);

        return String.format(SUCCESSFULLY_ADDED_SUPPLEMENT_IN_FIELD, supplementType, fieldName);
    }

    @Override
    public String addPlayer(String fieldName, String playerType, String playerName, String nationality, int strength) {
        Player player;

        switch (playerType) {
            case "Women":
                player = new Women(playerName, nationality, strength);
                break;
            case "Men":
                player = new Men(playerName, nationality, strength);
                break;
            default:
                throw new IllegalArgumentException(INVALID_PLAYER_TYPE);
        }

        Field field = fields.stream().filter(e -> e.getName().equals(fieldName)).findFirst().orElse(null);

        assert field != null;
        if (!isSuitableTerrain(field, player))   {
            return FIELD_NOT_SUITABLE;
        }   else {
            field.addPlayer(player);
            return String.format(SUCCESSFULLY_ADDED_PLAYER_IN_FIELD, playerType, fieldName);
        }
    }

    private boolean isSuitableTerrain(Field field, Player player) {
        String fieldType = field.getClass().getSimpleName();
        String playerType = player.getClass().getSimpleName();
        return fieldType.equals("ArtificialTurf") && playerType.equals("Women") || fieldType.equals("NaturalGrass") && playerType.equals("Men");
    }

    @Override
    public String dragPlayer(String fieldName) {
        Field field = fields.stream().filter(e -> e.getName().equals(fieldName)).findFirst().orElse(null);
        assert field != null;
        field.drag();
        return String.format(PLAYER_DRAG, field.getPlayers().size());
    }

    @Override
    public String calculateStrength(String fieldName) {
        Field field = fields.stream().filter(e -> e.getName().equals(fieldName)).findFirst().orElse(null);
        assert field != null;
        int totalStrength = field.getPlayers().stream().mapToInt(Player::getStrength).sum();
        return String.format(STRENGTH_FIELD, fieldName, totalStrength);
    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        fields.forEach(e -> sb.append(String.format("%s (%s):%n" +
                "Player: %s%n" +
                "Supplement: %d%n" +
                "Energy: %d%n", e.getName(), e.getClass().getSimpleName(),
                e.getPlayers().size() == 0 ? "none" : e.getPlayers().stream().map(Player::getName).collect(Collectors.joining(" ")),
                e.getSupplements().size(),
                e.sumEnergy())));
        return sb.toString().trim();
    }
}
