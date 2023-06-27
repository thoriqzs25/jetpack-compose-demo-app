package com.thariqzs.composedemo.data

data class ShoeSale(
    val id: Int,
    val shoeName: String,
    val price: Double,
    val quantitySold: Int,
    val revenue: Double,
    val addedAt: String,
    val description: String
)

object DummyData {

val shoeSales: List<ShoeSale> = listOf(
    ShoeSale(
        1,
        "Nike Air Max",
        99.99,
        50,
        4999.50,
        "2023-06-22 09:00:00",
        "Classic running shoes with visible Air cushioning."
    ),
    ShoeSale(
        2,
        "Adidas Ultraboost",
        129.99,
        40,
        5199.60,
        "2023-06-21 14:30:00",
        "High-performance shoes with responsive Boost cushioning."
    ),
    ShoeSale(
        3,
        "Puma Suede Classic",
        79.99,
        30,
        2399.70,
        "2023-06-20 11:45:00",
        "Iconic sneakers made with premium suede and rubber sole."
    ),
    ShoeSale(
        4,
        "Reebok Classic Leather",
        89.99,
        25,
        2249.75,
        "2023-06-19 16:15:00",
        "Timeless shoes crafted with soft leather upper and EVA midsole."
    ),
    ShoeSale(
        5,
        "New Balance 574",
        79.99,
        35,
        2799.65,
        "2023-06-18 10:30:00",
        "Versatile shoes featuring a retro design and comfortable cushioning."
    ),
    ShoeSale(
        6,
        "Vans Old Skool",
        69.99,
        20,
        1399.80,
        "2023-06-17 13:45:00",
        "Classic skateboarding shoes with canvas and suede upper."
    ),
    ShoeSale(
        7,
        "Converse Chuck Taylor",
        59.99,
        15,
        899.85,
        "2023-06-16 09:30:00",
        "Iconic high-top sneakers in various color options."
    ),
    ShoeSale(
        8,
        "Under Armour Curry",
        129.99,
        10,
        1299.90,
        "2023-06-15 11:15:00",
        "Basketball shoes designed for Stephen Curry with enhanced traction and support."
    ),
    ShoeSale(
        9,
        "ASICS Gel-Kayano",
        119.99,
        5,
        599.95,
        "2023-06-14 16:30:00",
        "Stability running shoes with advanced cushioning and support."
    ),
    ShoeSale(
        10,
        "Brooks Ghost",
        109.99,
        8,
        879.92,
        "2023-06-13 14:00:00",
        "Neutral running shoes with soft cushioning and smooth transitions."
    ),
    ShoeSale(
        11,
        "Salomon Speedcross",
        139.99,
        12,
        1679.88,
        "2023-06-12 17:45:00",
        "Trail running shoes with aggressive grip and lightweight design."
    ),
    ShoeSale(
        12,
        "Mizuno Wave Rider",
        99.99,
        18,
        1799.82,
        "2023-06-11 12:00:00",
        "Versatile running shoes known for their cushioning and responsiveness."
    ),
    ShoeSale(
        13,
        "Hoka One One Clifton",
        129.99,
        22,
        2859.78,
        "2023-06-10 09:30:00",
        "Maximalist running shoes with plush cushioning and a lightweight feel."
    ),
    ShoeSale(
        14,
        "Merrell Moab",
        89.99,
        14,
        1259.86,
        "2023-06-09 15:15:00",
        "Hiking shoes with durable construction and reliable traction."
    ),
    ShoeSale(
        15,
        "Saucony Kinvara",
        109.99,
        9,
        989.91,
        "2023-06-08 10:45:00",
        "Lightweight and responsive running shoes for neutral runners."
    ),
    ShoeSale(
        16,
        "Timberland Classic Boot",
        149.99,
        6,
        899.94,
        "2023-06-07 14:30:00",
        "Iconic waterproof boots with premium leather and sturdy construction."
    ),
    ShoeSale(
        17,
        "Dr. Martens 1460",
        169.99,
        3,
        509.97,
        "2023-06-06 11:00:00",
        "Classic leather boots with signature air-cushioned sole and yellow stitching."
    ),
    ShoeSale(
        18,
        "Fila Disruptor II",
        79.99,
        17,
        1359.83,
        "2023-06-05 15:45:00",
        "Chunky sneakers with a retro-inspired design and distinctive silhouette."
    ),
    ShoeSale(
        19,
        "Lacoste Carnaby Evo",
        89.99,
        11,
        989.89,
        "2023-06-04 10:15:00",
        "Tennis-inspired sneakers with a clean and classic look."
    ),
    ShoeSale(
        20,
        "Vibram FiveFingers",
        89.99,
        7,
        629.93,
        "2023-06-03 12:30:00",
        "Minimalist shoes with individual toe compartments for a barefoot-like experience."
    ),
)
}
