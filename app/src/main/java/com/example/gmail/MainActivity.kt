package com.example.gmail

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView : RecyclerView = findViewById(R.id.recyclerView)

        val items = ArrayList<Item>()

        items.add(Item("John wick", "john.wick@email.com", "23:09 PM", "Explore a diverse and fun collection of toys for children. From bicycles and dolls to smart puzzles, we bring joy and creativity to every family.", false, R.drawable.a))
        items.add(Item("Robert j", "robert.j@email.com", "21:55 PM", "Order today to enjoy fresh and delicious meals daily. With a diverse menu from Eastern delicacies to Western flavors, we guarantee satisfaction with every dish.", false, R.drawable.b))
        items.add(Item("James Gunn", "james.gunn@email.com", "21:50 PM", "Book a tour now to explore amazing destinations. Enjoy a relaxing vacation and create unforgettable memories at fantastic travel spots.", false, R.drawable.c))
        items.add(Item("Ricky tales", "rickey.tales@email.com", "17:42 PM", "Get special deals on a wide range of favorite products. Don't miss the chance to own the items you've been waiting for!", false, R.drawable.d))
        items.add(Item("Micky mose", "mickey.mouse@email.com", "17:29 PM", "Book a tour now to explore amazing destinations. Enjoy a relaxing vacation and create unforgettable memories at fantastic travel spots.", false, R.drawable.e))
        items.add(Item("Pick War", "pick.war@email.com", "16:17 PM", "Get special deals on a wide range of favorite products. Don't miss the chance to own the items you've been waiting for!", false, R.drawable.f))
        items.add(Item("Leg piece", "leg.piece@email.com", "15:35 PM", "Explore a diverse and fun collection of toys for children. From bicycles and dolls to smart puzzles, we bring joy and creativity to every family.", false, R.drawable.g))
        items.add(Item("Apple Mac", "apple.mac@email.com", "14:55 PM", "Order today to enjoy fresh and delicious meals daily. With a diverse menu from Eastern delicacies to Western flavors, we guarantee satisfaction with every dish.", false, R.drawable.g))
        items.add(Item("John wick", "john.wick@email.com", "09:28 AM", "Stay updated with leading tech products. From smartphones, laptops to tech accessories, we bring modernity and convenience to everyday life.", false, R.drawable.a))
        items.add(Item("Robert j", "robert.j@email.com", "09:16 AM", "Get special deals on a wide range of favorite products. Don't miss the chance to own the items you've been waiting for!", false, R.drawable.b))
        items.add(Item("James Gunn", "james.gunn@email.com", "06:04 AM", "Book a tour now to explore amazing destinations. Enjoy a relaxing vacation and create unforgettable memories at fantastic travel spots.", false, R.drawable.c))
        items.add(Item("Ricky tales", "rickey.tales@email.com", "05:42 AM", "Stay updated with leading tech products. From smartphones, laptops to tech accessories, we bring modernity and convenience to everyday life.", false, R.drawable.d))
        items.add(Item("Micky mose", "mickey.mouse@email.com", "04:20 AM", "Explore a diverse and fun collection of toys for children. From bicycles and dolls to smart puzzles, we bring joy and creativity to every family.", false, R.drawable.e))
        items.add(Item("Pick War", "pick.war@email.com", "03:51 AM", "Stay updated with leading tech products. From smartphones, laptops to tech accessories, we bring modernity and convenience to everyday life.", false, R.drawable.f))
        items.add(Item("Leg piece", "leg.piece@email.com", "01:03 AM", "Get special deals on a wide range of favorite products. Don't miss the chance to own the items you've been waiting for!", false, R.drawable.g))
        items.add(Item("Apple Mac", "apple.mac@email.com", "00:33 AM", "Order today to enjoy fresh and delicious meals daily. With a diverse menu from Eastern delicacies to Western flavors, we guarantee satisfaction with every dish.", false, R.drawable.g))

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = MyAdapter(applicationContext, items)
    }
}

class Item() {

    lateinit var name: String
    lateinit var email: String
    lateinit var time: String
    lateinit var content: String
    var checkBox: Boolean = false
    var image: Int = 0

    constructor(name: String, email: String, time: String, content: String, checkbox: Boolean, image: Int) : this() {
        this.name = name
        this.email = email
        this.time = time
        this.content = content
        this.checkBox = checkbox
        this.image = image
    }
}

class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var imageView: ImageView
    var nameView: TextView
    var emailView: TextView
    var timeView: TextView
    var contentView: TextView
    var checkBox: CheckBox

    init {
        imageView = itemView.findViewById(R.id.imageview)
        nameView = itemView.findViewById(R.id.name)
        emailView = itemView.findViewById(R.id.email)
        timeView = itemView.findViewById(R.id.time)
        contentView = itemView.findViewById(R.id.content)
        checkBox = itemView.findViewById(R.id.favourite)
    }
}

class MyAdapter() : RecyclerView.Adapter<MyViewHolder>() {

    private lateinit var items: List<Item>
    private lateinit var context: Context

    constructor(context: Context, items: List<Item>) : this() {
        this.context = context
        this.items = items
    }
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(context).inflate(R.layout.email_display, parent, false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.nameView.text = items[position].name
        holder.emailView.text = items[position].email
        holder.timeView.text = items[position].time
        holder.contentView.text = items[position].content
        holder.imageView.setImageResource(items[position].image)
        holder.checkBox.isChecked = items[position].checkBox
    }

}