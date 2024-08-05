package com.example.hayatwallet.scenes

import androidx.lifecycle.ViewModel
import com.example.hayatwallet.Network.Response.CampaignData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.jsoup.Jsoup
import org.jsoup.select.Elements

class CampaignViewModel : ViewModel() {


    public fun getData(callback: (List<CampaignData>) -> Unit) {
        GlobalScope.launch{
            withContext(Dispatchers.Main.immediate){
                val campaigns = withContext(Dispatchers.IO) {
                    fetchData()
                }
                callback(campaigns)
            }
        }
    }

    private fun fetchData(): List<CampaignData> {
        var campaigns = mutableListOf<CampaignData>()
        val doc = Jsoup.connect("https://www.hayatfinans.com.tr/kendim-icin-kampanyalar").get()
        val container = doc.body()
        val cards = container.getElementsByClass("card h-100")

        for (element in cards) {
            val card = element.getElementsByClass("card h-100")
            val imageUrl = card.first()?.getElementsByTag("img")?.first()?.attr("data-src")
            val title = card.first()?.getElementsByClass("card-title")?.first()?.text()
            val fullUrl = "https://www.hayatfinans.com.tr$imageUrl"
            val campaign = CampaignData(fullUrl,title)
            campaigns.add(campaign)
        }
        return campaigns
    }
}