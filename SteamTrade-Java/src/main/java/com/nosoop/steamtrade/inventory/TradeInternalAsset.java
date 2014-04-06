/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nosoop.steamtrade.inventory;

import bundled.steamtrade.org.json.JSONException;
import bundled.steamtrade.org.json.JSONObject;

/**
 * Represents a generic, tradable asset and its basic characteristics.
 *
 * @author nosoop < nosoop at users.noreply.github.com >
 */
public abstract class TradeInternalAsset {
    /**
     * The display name of the item. If the item was renamed (as it could be in
     * TF2, it will be that name.
     */
    String name;
    /**
     * The name it would be grouped under in the Steam Community Market. Is
     * blank if not in the Market.
     */
    String marketName;
    /**
     * The item's type, as obtained from its description.
     */
    String type;
    /**
     * The class number of this object. Two similar items (e.g., a pair of Loose
     * Cannons) will have the same class number.
     */
    int classid;
    /**
     * The number of items of this object has.
     */
    int amount;
    /**
     * The Steam appid for the game this object resides in.
     */
    int appid;
    /**
     * The inventory contextid for the game inventory this object resides in.
     */
    long contextid;
    /**
     * The item id number.
     */
    long assetid;

    /**
     * Creates a new TradeInternalObject instance.
     *
     * @param rgInventoryItem
     * @param rgDescriptionItem
     * @throws JSONException
     */
    TradeInternalAsset(JSONObject rgInventoryItem,
            JSONObject rgDescriptionItem) throws JSONException {
        this.name = rgDescriptionItem.getString("name");
        this.marketName = rgDescriptionItem.getString("market_name");
        this.type = rgDescriptionItem.getString("type");

        this.classid = Integer.parseInt(rgDescriptionItem.getString("classid"));

        this.amount = Integer.parseInt(
                rgInventoryItem.optString("amount", "-1"));
        this.assetid = Long.parseLong(rgInventoryItem.getString("id"));;
    }

    /**
     * Returns the display name of this asset, defaulting to its name. Allowed
     * to be overridden by subclasses.
     *
     * @return String representing the name of this asset.
     */
    public String getDisplayName() {
        return getName();
    }

    /**
     * Returns the name of this asset.
     *
     * @return
     */
    public final String getName() {
        return name;
    }

    /**
     * Returns the market name of this asset.
     *
     * @return The market name of this asset. If it does not have a market name,
     * it returns an empty string.
     */
    public final String getMarketName() {
        return marketName;
    }

    public final int getAppid() {
        return appid;
    }

    public final long getContextid() {
        return contextid;
    }

    public final long getAssetid() {
        return assetid;
    }

    public final int getClassid() {
        return classid;
    }
}
