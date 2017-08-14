package com.teamtreehouse.blog.dao;

import com.teamtreehouse.blog.model.BlogEntry;
import com.teamtreehouse.blog.model.Comment;
import com.teamtreehouse.blog.model.NotFoundException;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Trang on 8/3/2017.
 */
public class SimpleBlogDao implements BlogDao {
    private List<BlogEntry> blogEntries;



    public SimpleBlogDao() {
        this.blogEntries=new ArrayList<>();
        BlogEntry blogEntry1= new BlogEntry(" The best day I’ve ever had");
        blogEntry1.setBody("Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                "Nunc ut rhoncus felis, vel tincidunt neque. Vestibulum ut metus eleifend, " +
                "malesuada nisl at, scelerisque sapien. Vivamus pharetra massa libero, sed feugiat turpis efficitur at."+"\n" +
                "    Cras egestas ac ipsum in posuere. Fusce suscipit, libero id malesuada placerat, orci velit semper " +
                "metus, quis pulvinar sem nunc vel augue. In ornare tempor metus, sit amet congue justo porta et. " +
                "Etiam pretium, sapien non fermentum consequat, dolor augue gravida lacus, non accumsan lorem odio id risus. " +
                "Vestibulum pharetra tempor molestie. Integer sollicitudin ante ipsum, a luctus nisi egestas eu. Cras accumsan" +
                " cursus ante, non dapibus tempor");

        blogEntry1.setDateCreated(LocalDateTime.of(2016, Month.JANUARY, 31, 1, 00));
        blogEntry1.addTag("Tag1");

        BlogEntry blogEntry2= new BlogEntry("The absolute worst day I’ve ever had");
        blogEntry2.setDateCreated(LocalDateTime.of(2016, Month.JANUARY, 31, 1, 00));
        blogEntry2.addTag("Tag4");

        BlogEntry blogEntry3= new BlogEntry("That time at the mall");
        blogEntry3.setDateCreated(LocalDateTime.of(2016, Month.JANUARY, 31, 1, 00));

        blogEntry3.addTag("Tag1");
        blogEntry3.addTag("Tag2");
        blogEntry3.addTag("Tag3");

        BlogEntry blogEntry4= new BlogEntry("Dude, where’s my car?");
        blogEntry4.setDateCreated(LocalDateTime.of(2016, Month.JANUARY, 31, 1, 00));




        Comment c =new Comment("Carling Kirk");
        c.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc ut rhoncus felis, vel tincidunt neque. " +"\n"+
                "  Vestibulum ut metus eleifend, malesuada nisl at, scelerisque sapien. Vivamus pharetra massa libero, " +
                "sed feugiat turpis efficitur at.");
        c.setCommentDate(LocalDateTime.of(2016, Month.JANUARY, 31, 1, 00));


        blogEntry1.addComment(c);





        this.blogEntries.add(blogEntry1);
        this.blogEntries.add(blogEntry2);
        this.blogEntries.add(blogEntry3);
        this.blogEntries.add(blogEntry4);
    }

    @Override
    public boolean addEntry(BlogEntry blogEntry) {
        return blogEntries.add(blogEntry);
    }

    @Override
    public List<BlogEntry> findAllEntries() {
        return new ArrayList<>(blogEntries);
    }

    @Override
    public BlogEntry findEntryBySlug(String slug) {
        return blogEntries.stream()
                .filter(entry-> entry.getSlug().equals(slug))
                .findFirst()
                .orElseThrow(NotFoundException::new);
    }

    @Override
    public boolean removeEntry(BlogEntry blogEntry) {
        return  blogEntries.remove(blogEntry);
    }

    @Override
    public List<BlogEntry> findEntriesByTag(String tag) {
        List<BlogEntry> entriesCategorizedByTag=new ArrayList<>();
        for(BlogEntry blogEntry:blogEntries){
            if(blogEntry.getBlogEntryTags().contains(tag)){
                entriesCategorizedByTag.add(blogEntry);
            }
        }
        return entriesCategorizedByTag;
    }
}