package viceCity.models.neighbourhood;

import viceCity.models.guns.Gun;
import viceCity.models.players.Player;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Queue;

public class GangNeighbourhood implements Neighbourhood {

    public GangNeighbourhood() {
           }

    @Override
    public void action(Player mainPlayer, Collection<Player> civilPlayers) {

        Queue<Gun> mainPlayerGuns = new ArrayDeque<>(mainPlayer.getGunRepository().getModels());
        Queue<Player> players = new ArrayDeque<>(civilPlayers);

        Player player = players.poll();
        Gun gun = mainPlayerGuns.poll();

        while (gun != null && player != null) {
            while (gun.canFire() && player.isAlive()) {

                player.takeLifePoints(gun.fire());
            }
            if (gun.canFire()) {
                player = players.poll();
            } else if (player.isAlive()) {
                gun = mainPlayerGuns.poll();
            }
        }
        for (Player civilPlayer : civilPlayers) {
            if (civilPlayer.isAlive()) {
                ArrayDeque<Gun> civilPlayerGuns = new ArrayDeque<>(civilPlayer.getGunRepository().getModels());

                Gun playerGuns = civilPlayerGuns.poll();
                while (playerGuns != null) {
                    while (playerGuns.canFire() && mainPlayer.isAlive()) {

                        mainPlayer.takeLifePoints(playerGuns.fire());
                    }
                    if (!mainPlayer.isAlive()) {
                    return;
                    }
                    playerGuns = civilPlayerGuns.poll();
                }
            }
        }
    }
}
