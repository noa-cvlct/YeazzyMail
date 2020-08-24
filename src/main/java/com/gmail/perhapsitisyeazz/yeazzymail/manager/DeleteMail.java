package com.gmail.perhapsitisyeazz.yeazzymail.manager;

import com.gmail.perhapsitisyeazz.yeazzymail.util.Data;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Player;

public class DeleteMail {

	public static void deleteMail(Player sender, Integer integer, boolean confirm) {
		if (!confirm) {
			JsonObject object = Data.getJsonObject(sender);
			JsonArray array = object.getAsJsonArray("EmailList");
			int size = array.size();
			if (integer <= 0 && integer > size) {
				sender.sendMessage("This mail doesn't exist.");
				return;
			}
			sender.sendMessage(new ComponentBuilder()
					.append("     ")
					.append("YES")
					.event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, TextComponent.fromLegacyText("YES")))
					.event(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/mail delete " + integer + " confirm"))
					.append("           ").retain(ComponentBuilder.FormatRetention.NONE).reset()
					.append("NO")
					.event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, TextComponent.fromLegacyText("YES")))
					.event(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "test"))
					.create());
			return;
		}
		JsonObject object = Data.getJsonObject(sender);
		JsonArray array = object.getAsJsonArray("EmailList");
		array.remove(integer);
	}
}