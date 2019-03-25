package com.pankaj.pankaj;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MessageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<Object> messages;
    Context context;
    private static final int ID_SENT = 1;
    private static final int ID_RECEIVED = 2;
    private static final int ID_CENTER = 3;
    private static final int ID_Image_SENT = 4;
    private static final int ID_IMAGE_RECEIVED = 5;
    private static final int ID_NONE = 0;

    //constructor for message adapter that takes list of images
    public MessageAdapter(ArrayList<Object> messages) {
        this.messages = messages;
    }

    @Override
    public int getItemViewType(int position) {
        Object currentObj = messages.get(position);

        if (currentObj instanceof ReceivedMessage) {
            return ID_RECEIVED;
        } else if (currentObj instanceof SentMessage) {
            return ID_SENT;
        } else if (currentObj instanceof CenterAlignedMessage) {
            return ID_CENTER;
        } else if (currentObj instanceof ImageReceived) {
            return ID_IMAGE_RECEIVED;
        } else if (currentObj instanceof ImageSent) {
            return ID_Image_SENT;
        }else
            return ID_NONE;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int id) {

        context = viewGroup.getContext();
        LayoutInflater li = LayoutInflater.from(context);

        if (id == ID_SENT) {
            View sentView = li.inflate(R.layout.item_message_sent, viewGroup, false);
            return new SentHolder(sentView);
        } else if (id == ID_RECEIVED) {
            View receivedView = li.inflate(R.layout.item_message_received, viewGroup, false);
            return new ReceivedHolder(receivedView);
        }
        else if(id==ID_CENTER)
        {
            View receivedView = li.inflate(R.layout.item_center, viewGroup, false);
            return new CenterHolder(receivedView);
        }
        else if(id==ID_IMAGE_RECEIVED)
        {
            View imageReceivedView = li.inflate(R.layout.item_image_received, viewGroup, false);
            return new ImageReceivedHolder(imageReceivedView);
        }
        else if(id==ID_Image_SENT)
        {
            View imageSentView = li.inflate(R.layout.item_image_sent, viewGroup, false);
            return new ImageSentHolder(imageSentView);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        int currentObjectsId = getItemViewType(position);

        if (currentObjectsId == ID_SENT) {
            SentMessage sentMessage = (SentMessage) messages.get(position);
            SentHolder sentHolder = (SentHolder) viewHolder;
            sentHolder.tvSent.setText(sentMessage.getMessage());
            sentHolder.tvSent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ( (MainActivity) context).OnTap(context);
                }
            });
            sentHolder.container.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ((MainActivity) context).OnTap(context);
                }
            });
        } else if (currentObjectsId == ID_RECEIVED) {
            ReceivedMessage receivedMessage = (ReceivedMessage) messages.get(position);
            ReceivedHolder receivedHolder = (ReceivedHolder) viewHolder;
            receivedHolder.tvReceived.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ( (MainActivity) context).OnTap(context);
                }
            });
            receivedHolder.container.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ((MainActivity) context).OnTap(context);
                }
            });
            receivedHolder.tvReceived.setText(receivedMessage.getMessage());
        } else if (currentObjectsId == ID_CENTER) {
            CenterAlignedMessage centerMessage = (CenterAlignedMessage) messages.get(position);
            CenterHolder centerHolder = (CenterHolder) viewHolder;
            centerHolder.tvCenter.setText(centerMessage.getMessage());
            centerHolder.tvCenter.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ( (MainActivity) context).OnTap(context);
                }
            });
            centerHolder.container.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ((MainActivity) context).OnTap(context);
                }
            });
        } else if (currentObjectsId == ID_IMAGE_RECEIVED) {
            ImageReceived imageReceivedMessage = (ImageReceived) messages.get(position);
            ImageReceivedHolder imageReceivedHolder = (ImageReceivedHolder) viewHolder;
            Picasso.get().load(imageReceivedMessage.getMessage()).fit().into(imageReceivedHolder.tvImageReceived);
            imageReceivedHolder.tvImageReceived.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ( (MainActivity) context).OnTap(context);
                }
            });
            imageReceivedHolder.container.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ((MainActivity) context).OnTap(context);
                }
            });
        } else if (currentObjectsId == ID_Image_SENT) {
            ImageSent imageSentMessage = (ImageSent) messages.get(position);
            ImageSentHolder imageSentHolder = (ImageSentHolder) viewHolder;
            Picasso.get().load(imageSentMessage.getMessage()).fit().into(imageSentHolder.tvImageSent);
            imageSentHolder.tvImageSent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ( (MainActivity) context).OnTap(context);
                }
            });
            imageSentHolder.container.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ((MainActivity) context).OnTap(context);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return messages.size();
    }

    class SentHolder extends RecyclerView.ViewHolder {
        TextView tvSent;
        ConstraintLayout container;
        public SentHolder(@NonNull View itemView) {
            super(itemView);
            tvSent = itemView.findViewById(R.id.tvSent);
            container=itemView.findViewById(R.id.container);
        }
    }
    class ReceivedHolder extends RecyclerView.ViewHolder {
        TextView tvReceived;
        ConstraintLayout container;
        public ReceivedHolder(@NonNull View itemView) {
            super(itemView);
            tvReceived = itemView.findViewById(R.id.tvReceived);
            container=itemView.findViewById(R.id.container);
        }
    }
    class CenterHolder extends RecyclerView.ViewHolder {
        TextView tvCenter;
        ConstraintLayout container;
        public CenterHolder(@NonNull View itemView) {
            super(itemView);
            tvCenter = itemView.findViewById(R.id.tvCenter);
            container=itemView.findViewById(R.id.container);
        }
    }
    class ImageReceivedHolder extends RecyclerView.ViewHolder {
        ImageView tvImageReceived;
        ConstraintLayout container;
        public ImageReceivedHolder(@NonNull View itemView) {
            super(itemView);
            tvImageReceived = itemView.findViewById(R.id.tvImageReceived);
            container=itemView.findViewById(R.id.container);
        }
    }
    class ImageSentHolder extends RecyclerView.ViewHolder {
        ImageView tvImageSent;
        ConstraintLayout container;
        public ImageSentHolder(@NonNull View itemView) {
            super(itemView);
            tvImageSent = itemView.findViewById(R.id.tvImageSent);
            container=itemView.findViewById(R.id.container);
        }
    }
}