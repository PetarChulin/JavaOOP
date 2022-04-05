package viceCity.core.interfaces;

import com.sun.source.tree.LiteralTree;
import viceCity.models.guns.Gun;
import viceCity.models.guns.Pistol;
import viceCity.models.guns.Rifle;
import viceCity.models.neighbourhood.GangNeighbourhood;
import viceCity.models.neighbourhood.Neighbourhood;
import viceCity.models.players.CivilPlayer;
import viceCity.models.players.MainPlayer;
import viceCity.models.players.Player;
import viceCity.repositories.interfaces.GunRepository;
import viceCity.repositories.interfaces.Repository;

import java.util.*;
import java.util.stream.Collectors;

import static javax.swing.Action.NAME;
import static viceCity.common.ConstantMessages.*;

public class ControllerImpl implements Controller {

    private final Player mainPlayer;
    private final ArrayDeque<Gun> guns;
    private final Neighbourhood neighbourhood;
    private final Map<String, Player> players;
    private Gun gun;

    public ControllerImpl() {
        this.mainPlayer = new MainPlayer();
        this.guns = new ArrayDeque<>();
        this.neighbourhood = new GangNeighbourhood();
        this.players = new LinkedHashMap<>();
    }

    @Override
    public String addPlayer(String name) {

        Player player = new CivilPlayer(name);

        players.putIfAbsent(player.getName() , player);

        return String.format(PLAYER_ADDED, name);
    }

    @Override
    public String addGun(String type, String name) {

        switch (type) {
            case "Pistol":
                guns.add(new Pistol(name));
                break;
            case "Rifle":
                guns.add(new Rifle(name));
                break;
            default:
                return GUN_TYPE_INVALID;
        }
        return String.format(GUN_ADDED, name, type);
    }

    @Override
    public String addGunToPlayer(String name) {

        if (guns.isEmpty()) {
            return GUN_QUEUE_IS_EMPTY;
        }

        if (name.equals("Vercetti")) {
            gun = guns.poll();
            mainPlayer.getGunRepository().add(gun);
            return String.format(GUN_ADDED_TO_MAIN_PLAYER, gun.getName(), mainPlayer.getName());
        } else {
            if (this.players.get(name) == null) {
                return CIVIL_PLAYER_DOES_NOT_EXIST;
            }
            gun = guns.poll();
            this.players.get(name).getGunRepository().add(gun);
            return String.format(GUN_ADDED_TO_CIVIL_PLAYER, gun.getName(), name);
        }
    }

    @Override
    public String fight() {

        this.neighbourhood.action(mainPlayer, players.values());

        if (mainPlayer.getLifePoints() == 100 && players.values().stream().allMatch(p-> p.getLifePoints() == 50)) {
            return FIGHT_HOT_HAPPENED;
        }

        List<Player> deadCivil = players.values().stream().filter(p-> !p.isAlive()).collect(Collectors.toList());

        StringBuilder build = new StringBuilder(FIGHT_HAPPENED).append("\n");

        build.append(String.format(MAIN_PLAYER_LIVE_POINTS_MESSAGE, mainPlayer.getLifePoints())).append("\n");
        build.append(String.format(MAIN_PLAYER_KILLED_CIVIL_PLAYERS_MESSAGE, deadCivil.size())).append("\n");
        build.append(String.format(CIVIL_PLAYERS_LEFT_MESSAGE, players.size() - deadCivil.size()));

        return build.toString();
    }
}
