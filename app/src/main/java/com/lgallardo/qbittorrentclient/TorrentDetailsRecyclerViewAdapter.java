/*
 *   Copyright (c) 2014-2015 Luis M. Gallardo D.
 *   All rights reserved. This program and the accompanying materials
 *   are made available under the terms of the GNU Lesser General Public License v3.0
 *   which accompanies this distribution, and is available at
 *   http://www.gnu.org/licenses/lgpl.html
 *
 */

package com.lgallardo.qbittorrentclient;

/**
 * Created by lgallard on 28/08/15.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Iterator;

public class TorrentDetailsRecyclerViewAdapter extends RecyclerView.Adapter<TorrentDetailsRecyclerViewAdapter.ViewHolder> {

    // Declaring Variable to Understand which View is being worked on
    // IF the view under inflation and population is header or Item
    private static final int TYPE_FILE_ITEM = 0;
    private static final int TYPE_TRACKER_ITEM = 1;


    // All items
    public static ArrayList<TorrentDetailsItem> items;

    // Subitems
    public static ArrayList<TorrentDetailsItem> fileItems;
    public static ArrayList<TorrentDetailsItem> trackerItems;

    public static ArrayList<TorrentDetailsItem> serverItems;
    public static ArrayList<TorrentDetailsItem> actionItems;
    public static ArrayList<TorrentDetailsItem> settingsItems;
    public static ArrayList<TorrentDetailsItem> labelItems;

    private static MainActivity mainActivity;

    private Context context;


    // Creating a ViewHolder which extends the RecyclerView View Holder
    // ViewHolder are used to to store the inflated views in order to recycle them


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        int Holderid;


        public ViewHolder(final View itemView, int ViewType) {                 // Creating ViewHolder Constructor with View and viewType As a parameter
            super(itemView);

            Holderid = 0;

        }


        // In order to track the item position in RecyclerView
        // Handle item click and set the selection
        @Override
        public void onClick(View view) {


            TorrentDetailsItem recyclerItem;


            // Get item
            recyclerItem = items.get(getLayoutPosition());


            // Perform Action

            // Set file priority

            if (recyclerItem.getAction().equals("setFilePriority")) {

                Log.d("Debug", "setFilePriority");
                //notifyDataSetChanged();

            }

            // Add tracker
            if (recyclerItem.getAction().equals("addTracker")) {

                Log.d("Debug", "addTracker");
                //notifyDataSetChanged();
            }


        }

    }


    TorrentDetailsRecyclerViewAdapter(Context context, MainActivity mainActivity, ArrayList<TorrentDetailsItem> serverItems, ArrayList<TorrentDetailsItem> actionItems, ArrayList<TorrentDetailsItem> settingsItems, ArrayList<TorrentDetailsItem> labelItems) {

        this.mainActivity = mainActivity;
        this.context = context;


        // All items

        TorrentDetailsRecyclerViewAdapter.serverItems = serverItems;
        TorrentDetailsRecyclerViewAdapter.actionItems = actionItems;
        TorrentDetailsRecyclerViewAdapter.settingsItems = settingsItems;
        TorrentDetailsRecyclerViewAdapter.labelItems = labelItems;

        TorrentDetailsRecyclerViewAdapter.items = new ArrayList<TorrentDetailsItem>();

        // Add items
        TorrentDetailsRecyclerViewAdapter.items.addAll(serverItems);
        TorrentDetailsRecyclerViewAdapter.items.addAll(actionItems);
        TorrentDetailsRecyclerViewAdapter.items.addAll(settingsItems);

        if (labelItems != null) {
            TorrentDetailsRecyclerViewAdapter.items.addAll(labelItems);
        } else {
            TorrentDetailsRecyclerViewAdapter.labelItems = new ArrayList<TorrentDetailsItem>();
        }

//        Log.d("Debug", "DrawerItemRecyclerViewAdapter - Constructor - serverItems size: " + TorrentDetailsItemRecyclerViewAdapter.serverItems.size());
//        Log.d("Debug", "DrawerItemRecyclerViewAdapter - Constructor - actionItems size: " + TorrentDetailsItemRecyclerViewAdapter.actionItems.size());
//        Log.d("Debug", "DrawerItemRecyclerViewAdapter - Constructor - settingsItems size: " + TorrentDetailsItemRecyclerViewAdapter.settingsItems.size());
//        Log.d("Debug", "DrawerItemRecyclerViewAdapter - Constructor - labelItems size: " + TorrentDetailsItemRecyclerViewAdapter.labelItems.size());
//        Log.d("Debug", "DrawerItemRecyclerViewAdapter - Constructor - items size: " + TorrentDetailsItemRecyclerViewAdapter.items.size());

//        drawerOffset = 1;

        TorrentDetailsItem recyclerItem;

//        // Add server items to array
//        for (int i = 0; i < items.size(); i++) {
//            ObjectDrawerItem item = items.get(i);
//
//            Log.d("Debug", "DrawerItemRecyclerViewAdapter - OnClick() - Adding to items: " + items.get(i).name);
//
//            if (item.getType() == TYPE_SERVER || item.getType() == TYPE_SERVER_ACTIVE) {
//                serverItems.add(item);
//            }
//        }


        // Remove all server items
        Iterator iterator = items.iterator();

        while (iterator.hasNext()) {

            TorrentDetailsItem item = (TorrentDetailsItem) iterator.next();

//            Log.d("Debug", "DrawerItemRecyclerViewAdapter - OnClick() - Analysing: " + item.name);
//            Log.d("Debug", "DrawerItemRecyclerViewAdapter - OnClick() - Action is: " + item.getAction());

//
//            if (item.getType() == TYPE_SERVER || item.getType() == TYPE_SERVER_ACTIVE) {
//
////                Log.d("Debug", "DrawerItemRecyclerViewAdapter - OnClick() - Removing: " + item.name);
//                iterator.remove();
//            }


        }


    }


    //Below first we override the method onCreateViewHolder which is called when the ViewHolder is
    //Created, In this method we inflate the item_row.xml layout if the viewType is Type_ITEM or else we inflate header.xml
    // if the viewType is TYPE_HEADER
    // and pass it to the view holder

    @Override
    public TorrentDetailsRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

//        Log.d("Debug", "DrawerItemRecyclerViewAdapter - OnClick() - ViewType: " + viewType);
//        if (viewType == TYPE_SERVER || viewType == TYPE_SERVER_ACTIVE) {
//            drawerOffset = drawerOffset + 1;
//        }

        //inflate your layout and pass it to view holder
        if (viewType == TYPE_FILE_ITEM) {

            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.contentfile_row, parent, false); //Inflating the layout
            ViewHolder vhItem = new ViewHolder(v, viewType); //Creating ViewHolder and passing the object of type view

            return vhItem; // Returning the created object

        } else if (viewType == TYPE_TRACKER_ITEM) {

            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.tracker_row, parent, false); //Inflating the layout
            ViewHolder vhItem = new ViewHolder(v, viewType); //Creating ViewHolder and passing the object of type view
            return vhItem; // Returning the created object

        }

        return null;

    }

    //Next we override a method which is called when the item in a row is needed to be displayed, here the int position
    // Tells us item at which position is being constructed to be displayed and the holder id of the holder object tell us
    // which view type is being created 1 for item row
    @Override
    public void onBindViewHolder(TorrentDetailsRecyclerViewAdapter.ViewHolder holder, int position) {
//        if (holder.Holderid == 1) {                              // as the list view is going to be called after the header view so we decrement the
//            // position by 1 and pass it to the holder while setting the text and image
//
//
//            TorrentDetailsItem item = items.get(position - 1);
//
//            holder.imageViewIcon.setImageResource(item.icon);
//            holder.textViewName.setText(item.name);
//
//
//            holder.positionInItems = (position - 1);
//
//
//        } else {
//
//            // header
//
//            return;
//        }
    }


    // This method returns the number of items present in the list
    @Override
    public int getItemCount() {
        // Return the number of items in the list (header + item actions)
        return items.size() + 1;
    }


    // Witht the following method we check what type of view is being passed
    @Override
    public int getItemViewType(int position) {

//        Log.d("Debug", "DrawerItemRecyclerViewAdapter - items.size(): " + items.size());
//        Log.d("Debug", "DrawerItemRecyclerViewAdapter - position: " + position);

//        if (isPositionHeader(position)) {
////            Log.d("Debug", "DrawerItemRecyclerViewAdapter - TYPE_HEADER");
//            return TYPE_HEADER;
//        }

//        if (items.get(position - 1).getType() == TYPE_CATEGORY && !(items.get(position - 1).isActive())) {
////            Log.d("Debug", "DrawerItemRecyclerViewAdapter - TYPE_CATEGORY");
//            return TYPE_CATEGORY;
//        }

//        if (items.get(position - 1).getType() == TYPE_CATEGORY && items.get(position - 1).isActive()) {
////            Log.d("Debug", "DrawerItemRecyclerViewAdapter - TYPE_CATEGORY");
//            return TYPE_CATEGORY;
//        }
//
//        if (items.get(position - 1).getType() == TYPE_LABEL_CATEGORY && !(items.get(position - 1).isActive())) {
////            Log.d("Debug", "DrawerItemRecyclerViewAdapter - TYPE_LABEL_CATEGORY");
//            return TYPE_LABEL_CATEGORY;
//        }
//
//        if (items.get(position - 1).getType() == TYPE_LABEL_CATEGORY && items.get(position - 1).isActive()) {
////            Log.d("Debug", "DrawerItemRecyclerViewAdapter - TYPE_LABEL_CATEGORY");
//            return TYPE_LABEL_CATEGORY;
//        }
//
//
//        if (items.get(position - 1).getType() == TYPE_SERVER && !(items.get(position - 1).isActive())) {
////            Log.d("Debug", "DrawerItemRecyclerViewAdapter - TYPE_SERVER");
//            return TYPE_SERVER;
//        }
//
//        if (items.get(position - 1).getType() == TYPE_SERVER && items.get(position - 1).isActive()) {
////            Log.d("Debug", "DrawerItemRecyclerViewAdapter - TYPE_SERVER_ACTIVE");
//            return TYPE_SERVER_ACTIVE;
//        }
//
//
//        if (items.get(position - 1).getType() == TYPE_LABEL && !(items.get(position - 1).isActive())) {
////            Log.d("Debug", "DrawerItemRecyclerViewAdapter - TYPE_LABEL");
//            return TYPE_LABEL;
//        }
//
//        if (items.get(position - 1).getType() == TYPE_LABEL && items.get(position - 1).isActive()) {
////            Log.d("Debug", "DrawerItemRecyclerViewAdapter - TYPE_LABEL_ACTIVE");
//            return TYPE_LABEL_ACTIVE;
//        }

        // Default
//        Log.d("Debug", "DrawerItemRecyclerViewAdapter - TYPE_FILE_ITEM");
        return TYPE_FILE_ITEM;

    }

    private boolean isPositionHeader(int position) {
        return position == 0;
    }

}
